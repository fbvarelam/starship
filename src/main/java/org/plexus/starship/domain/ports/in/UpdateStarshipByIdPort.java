package org.plexus.starship.domain.ports.in;

import org.plexus.starship.domain.Starship;
import org.plexus.starship.domain.exceptions.StarshipNotFoundException;

public interface UpdateStarshipByIdPort {
    Starship execute(final long id, final Starship starship) throws StarshipNotFoundException;
}
