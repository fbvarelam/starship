package org.plexus.starship.application.usecases;

import org.plexus.starship.domain.Starship;
import org.plexus.starship.domain.exceptions.StarshipNotFoundException;
import org.plexus.starship.domain.ports.in.UpdateStarshipByIdPort;
import org.plexus.starship.domain.ports.out.UpdateStarshipRepositoryPort;

public class UpdateStarshipByIdUseCase implements UpdateStarshipByIdPort {

    private final UpdateStarshipRepositoryPort updateStarshipRepositoryPort;

    public UpdateStarshipByIdUseCase(final UpdateStarshipRepositoryPort updateStarshipRepositoryPort) {
        this.updateStarshipRepositoryPort = updateStarshipRepositoryPort;
    }

    @Override
    public Starship execute(final long id, final Starship starship) throws StarshipNotFoundException {

        return this.updateStarshipRepositoryPort.execute(id, starship)
                .orElseThrow(() -> new StarshipNotFoundException("Starship with id " + id + " not found"));
    }
}
