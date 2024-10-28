package org.plexus.starship.domain.ports.in;

import org.plexus.starship.domain.Starship;

public interface NewStarshipPort {
    Starship execute(final Starship starship);
}
