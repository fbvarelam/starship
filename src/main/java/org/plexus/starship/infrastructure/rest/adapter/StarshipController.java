package org.plexus.starship.infrastructure.rest.adapter;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.StarshipApi;
import org.openapitools.model.StarshipResponse;
import org.plexus.starship.domain.exceptions.StarshipNotFoundException;
import org.plexus.starship.domain.ports.in.DeleteStarshipByIdPort;
import org.plexus.starship.domain.ports.in.GetStarshipByIdPort;
import org.plexus.starship.domain.ports.in.GetStarshipsByNamePort;
import org.plexus.starship.domain.ports.in.GetStarshipsPort;
import org.plexus.starship.domain.ports.in.UpdateStarshipByIdPort;
import org.plexus.starship.domain.ports.out.NewStarshipRepositoryPort;
import org.plexus.starship.domain.ports.out.NotifyStarshipRepositoryPort;
import org.plexus.starship.infrastructure.rest.exceptions.StarshipNotFoundRestException;
import org.plexus.starship.infrastructure.rest.mapper.RestMapper;
import org.plexus.starship.infrastructure.rest.model.StarshipRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/starships")
@RequiredArgsConstructor
public class StarshipController implements StarshipApi {

    private final GetStarshipByIdPort getStarshipByIdPort;
    private final GetStarshipsPort getStarshipsPort;
    private final DeleteStarshipByIdPort deleteStarshipByIdPort;
    private final NewStarshipRepositoryPort newStarshipRepositoryPort;
    private final UpdateStarshipByIdPort updateStarshipByIdPort;
    private final GetStarshipsByNamePort getStarshipsByNamePort;
    private final NotifyStarshipRepositoryPort notifyStarshipRepositoryPort;

    private final RestMapper restMapper;

    @GetMapping
    public ResponseEntity<Page<StarshipResponse>> getAllStarships(@PageableDefault() final Pageable pageable) {

        final var response = this.getStarshipsPort.execute(pageable)
                .map(this.restMapper::toResponse);

        this.notifyStarshipRepositoryPort.execute("Get all starships");

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<StarshipResponse> createStarship(@Valid @RequestBody final StarshipRequest request) {

        final var starship = this.restMapper.toDomain(request);
        final var starshipSaved = this.newStarshipRepositoryPort.execute(starship);

        this.notifyStarshipRepositoryPort.execute("Create starship");

        final var response = this.restMapper.toResponse(starshipSaved);

        return ResponseEntity.status(201).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StarshipResponse> getStarshipById(@PathVariable final Long id) {

        try {
            final var starship = this.getStarshipByIdPort.execute(id);
            this.notifyStarshipRepositoryPort.execute("Get starship by id");

            final var response = this.restMapper.toResponse(starship);

            return ResponseEntity.ok(response);

        } catch (StarshipNotFoundException e) {
            throw new StarshipNotFoundRestException(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<StarshipResponse> updateStarshipById(@Valid
                                                               @PathVariable final Long id,
                                                               @RequestBody final StarshipRequest request) {
        try {
            final var starship = this.restMapper.toDomain(request);
            final var starshipUpdated = this.updateStarshipByIdPort.execute(id, starship);

            this.notifyStarshipRepositoryPort.execute("Update starship by id");

            final var response = this.restMapper.toResponse(starshipUpdated);

            return ResponseEntity.ok(response);

        } catch (StarshipNotFoundException e) {
            throw new StarshipNotFoundRestException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStarshipById(@PathVariable final Long id) {

        try {
            this.deleteStarshipByIdPort.execute(id);
            this.notifyStarshipRepositoryPort.execute("Delete starship by id");

        } catch (StarshipNotFoundException e) {
            throw new StarshipNotFoundRestException(e.getMessage());
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<StarshipResponse>> searchStarshipsByName(@Valid @RequestParam @NotBlank final String name) {

        final var response = this.getStarshipsByNamePort.execute(name).stream()
                .map(this.restMapper::toResponse)
                .toList();

        this.notifyStarshipRepositoryPort.execute("Search starship by name");

        return ResponseEntity.ok(response);
    }
}
