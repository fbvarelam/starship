package org.plexus.starship.infrastructure.rest.exceptions;

public class StarshipNotFoundRestException extends RuntimeException {

    public StarshipNotFoundRestException(String message) {
        super(message);
    }
}
