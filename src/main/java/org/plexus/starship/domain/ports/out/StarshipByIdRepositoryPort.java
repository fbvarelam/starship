package org.plexus.starship.domain.ports.out;

import org.plexus.starship.domain.Starship;

import java.util.Optional;

public interface StarshipByIdRepositoryPort {
    Optional<Starship> execute(long id);
}
