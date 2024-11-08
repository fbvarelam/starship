package org.plexus.starship.infrastructure.rest.exceptions;

public class StarshipNotFoundRestException extends RuntimeException {

    public StarshipNotFoundRestException(final String message) {
        super(message);
    }
}
