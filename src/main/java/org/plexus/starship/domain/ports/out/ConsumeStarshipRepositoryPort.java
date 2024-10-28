package org.plexus.starship.domain.ports.out;

import org.plexus.starship.domain.Starship;

public interface ConsumeStarshipRepositoryPort {
    Starship execute(final Starship starship);
}
