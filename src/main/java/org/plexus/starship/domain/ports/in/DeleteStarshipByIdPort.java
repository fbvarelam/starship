package org.plexus.starship.domain.ports.in;

import org.plexus.starship.domain.exceptions.StarshipNotFoundException;

public interface DeleteStarshipByIdPort {
    void execute(final long id) throws StarshipNotFoundException;
}
