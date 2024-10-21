package org.plexus.starship.infrastructure.rest.model;

import javax.validation.constraints.NotBlank;

public record StarshipRequest(
        @NotBlank
        String name,
        @NotBlank
        String type
) {
}
