package org.plexus.starship.domain.ports.out;

import org.plexus.starship.domain.Starship;

public interface NewStarshipRepositoryPort {
    Starship execute(final Starship starship);
}
