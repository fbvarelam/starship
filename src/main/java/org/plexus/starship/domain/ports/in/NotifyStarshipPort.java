package org.plexus.starship.domain.ports.in;

import org.plexus.starship.domain.Starship;

public interface NotifyStarshipPort {
    Starship execute(final Starship starship);
}
