package org.plexus.starship.domain.ports.out;

import org.plexus.starship.domain.Starship;

import java.util.Optional;

public interface UpdateStarshipRepositoryPort {
    Optional<Starship> execute(final long id, final Starship starship);
}
