package org.plexus.starship.domain.ports.in;

import org.plexus.starship.domain.Starship;

public interface GetStarshipByIdPort {
    Starship execute(final long id);
}
