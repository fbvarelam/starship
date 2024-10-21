package org.plexus.starship.infrastructure.rest.adapter;

import lombok.RequiredArgsConstructor;
import org.openapitools.api.StarshipApi;
import org.openapitools.model.StarshipRequest;
import org.openapitools.model.StarshipResponse;
import org.plexus.starship.domain.ports.in.*;
import org.plexus.starship.infrastructure.rest.mapper.RestMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("/api/starships")
@RequiredArgsConstructor
public class StarshipController implements StarshipApi {

    private final GetStarshipByIdPort getStarshipByIdPort;
    private final GetStarshipsPort getStarshipsPort;
    private final DeleteStarshipByIdPort deleteStarshipByIdPort;
    private final CreateStarshipPort createStarshipPort;
    private final UpdateStarshipByIdPort updateStarshipByIdPort;
    private final GetStarshipsByNamePort getStarshipsByNamePort;

    private final RestMapper restMapper;

    @GetMapping
    public ResponseEntity<Page<StarshipResponse>> getAllStarships(
            @PageableDefault() Pageable pageable) {

        var starships = this.getStarshipsPort.execute(pageable);
        var response = starships.map(this.restMapper::toResponse);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<StarshipResponse> createStarship(@Valid @RequestBody StarshipRequest request) {
        var starshipSaved = this.createStarshipPort.execute(restMapper.toDomain(request));
        var response = this.restMapper.toResponse(starshipSaved);

        return ResponseEntity.status(201).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StarshipResponse> getStarshipById(@PathVariable Long id) {
        var starship = this.getStarshipByIdPort.execute(id);
        var response = this.restMapper.toResponse(starship);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StarshipResponse> updateStarshipById(@Valid
                                                               @PathVariable Long id, @RequestBody StarshipRequest request) {

        var starship = this.restMapper.toDomain(request);
        var starshipUpdated = this.updateStarshipByIdPort.execute(id, starship);

        var response = this.restMapper.toResponse(starshipUpdated);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStarshipById(@PathVariable Long id) {
        this.deleteStarshipByIdPort.execute(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<StarshipResponse>> searchStarshipsByName(@Valid @RequestParam @NotBlank String name) {
        var starships = this.getStarshipsByNamePort.execute(name);
        var response = starships.stream()
                .map(this.restMapper::toResponse)
                .toList();

        return ResponseEntity.ok(response);
    }
}
