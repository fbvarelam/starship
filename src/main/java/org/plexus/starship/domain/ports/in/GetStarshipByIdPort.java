package org.plexus.starship.domain.ports.in;

import org.plexus.starship.domain.Starship;
import org.plexus.starship.domain.exceptions.StarshipNotFoundException;

public interface GetStarshipByIdPort {
    Starship execute(final long id) throws StarshipNotFoundException;
}
