package org.plexus.starship.domain.ports.in;

import org.plexus.starship.infrastructure.jpa.model.Starship;

public interface CreateStarshipPort {
    void execute(final Starship starship);
}
