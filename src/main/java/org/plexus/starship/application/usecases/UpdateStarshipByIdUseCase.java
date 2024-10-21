package org.plexus.starship.application.usecases;

import org.plexus.starship.domain.Starship;
import org.plexus.starship.domain.ports.in.UpdateStarshipByIdPort;
import org.plexus.starship.domain.ports.out.UpdateStarshipRepositoryPort;

public class UpdateStarshipByIdUseCase implements UpdateStarshipByIdPort {

    private final UpdateStarshipRepositoryPort updateStarshipRepositoryPort;

    public UpdateStarshipByIdUseCase(UpdateStarshipRepositoryPort updateStarshipRepositoryPort) {
        this.updateStarshipRepositoryPort = updateStarshipRepositoryPort;
    }

    @Override
    public Starship execute(final long id, final Starship starship) {

        return this.updateStarshipRepositoryPort.execute(id, starship);

    }
}
