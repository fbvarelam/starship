package org.plexus.starship.domain.ports.out;

import org.plexus.starship.domain.Starship;

public interface UpdateStarshipRepositoryPort {
    Starship execute(final long id, final Starship starship);
}
