package org.plexus.starship.infrastructure.rest.adapter;

import org.openapitools.api.StarshipApi;
import org.openapitools.model.StarshipRequest;
import org.openapitools.model.StarshipResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/starships")
public class StarshipController implements StarshipApi {

    @GetMapping
    public ResponseEntity<Page<StarshipResponse>> getAllStarships(
            @PageableDefault(size = 10) Pageable pageable) {

        return ResponseEntity.ok(null);
    }

    @PostMapping
    public ResponseEntity<StarshipResponse> createStarship(@RequestBody StarshipRequest request) {
        return ResponseEntity.status(201).body(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StarshipResponse> getStarshipById(@PathVariable Long id) {
        return ResponseEntity.ok(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StarshipResponse> updateStarshipById(
            @PathVariable Long id, @RequestBody StarshipRequest request) {
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStarshipById(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<StarshipResponse>> searchStarshipsByName(@RequestParam String name) {
        return ResponseEntity.ok(null);
    }
}
