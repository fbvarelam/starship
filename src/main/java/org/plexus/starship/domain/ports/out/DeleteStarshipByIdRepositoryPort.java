package org.plexus.starship.domain.ports.out;

import org.plexus.starship.domain.exceptions.StarshipNotFoundException;

public interface DeleteStarshipByIdRepositoryPort {
    void execute(long id) throws StarshipNotFoundException;
}
