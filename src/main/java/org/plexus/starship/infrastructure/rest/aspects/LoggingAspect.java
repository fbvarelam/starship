package org.plexus.starship.infrastructure.rest.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class LoggingAspect {

    @Before("execution(* org.plexus.starship.infrastructure.rest.adapter.StarshipController.getStarshipById(..)) && args(id)")
    public void logIfNegativeId(final long id) {
        if (id < 0) {
            log.warn("Request for starship with negative id: {}", id);
        }
    }
}
