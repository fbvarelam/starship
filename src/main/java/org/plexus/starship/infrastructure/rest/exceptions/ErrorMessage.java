package org.plexus.starship.infrastructure.rest.exceptions;

public record ErrorMessage(
        String message,
        String description
) {

}
