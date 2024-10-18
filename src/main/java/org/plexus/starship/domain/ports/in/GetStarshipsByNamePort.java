package org.plexus.starship.domain.ports.in;

import org.plexus.starship.infrastructure.jpa.model.Starship;

import java.util.List;

public interface GetStarshipsByNamePort {
    List<Starship> execute(final String name);
}
