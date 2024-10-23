package org.plexus.starship.infrastructure.rest.model;


import jakarta.validation.constraints.NotBlank;

public record StarshipRequest(

        @NotBlank(message = "name field cannot be blank")
        String name,
        @NotBlank(message = "type field cannot be blank")
        String type
) {
}
