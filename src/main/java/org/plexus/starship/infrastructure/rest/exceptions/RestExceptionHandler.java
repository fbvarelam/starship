package org.plexus.starship.infrastructure.rest.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;

import java.util.Objects;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorMessage> handleMethodArgumentNotValidException(final MethodArgumentNotValidException ex) {
        final var errorResponse = new ErrorMessage("Invalid request", Objects.requireNonNull(ex.getDetailMessageArguments())[1].toString());

        log.error("MethodArgumentNotValidException: {}", errorResponse.description());
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorMessage> handleIllegalArgumentException(final IllegalArgumentException ex) {
        final var errorResponse = new ErrorMessage("Invalid request", ex.getMessage());

        log.error("IllegalArgumentException: {}", errorResponse.description());
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(StarshipNotFoundRestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorMessage> handleStarshipNotFoundRestException(final StarshipNotFoundRestException ex) {
        final var errorResponse = new ErrorMessage("Resource not found", ex.getMessage());

        log.error("StarshipNotFoundRestException: {}", errorResponse.description());
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorMessage> handleInternalServerErrorException(final HttpServerErrorException.InternalServerError ex) {
        final var errorResponse = new ErrorMessage("Contact the admin", ex.getMessage());

        log.error("InternalServerError: {}", errorResponse.description());
        return ResponseEntity.internalServerError().body(errorResponse);
    }
}
