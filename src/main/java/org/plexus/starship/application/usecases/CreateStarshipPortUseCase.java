package org.plexus.starship.application.usecases;

import org.plexus.starship.domain.Starship;
import org.plexus.starship.domain.ports.in.CreateStarshipPort;
import org.plexus.starship.domain.ports.out.CreateStarshipRepositoryPort;

public class CreateStarshipPortUseCase implements CreateStarshipPort {

    private final CreateStarshipRepositoryPort createStarshipRepositoryPort;

    public CreateStarshipPortUseCase(CreateStarshipRepositoryPort createStarshipRepositoryPort) {
        this.createStarshipRepositoryPort = createStarshipRepositoryPort;
    }

    @Override
    public Starship execute(final Starship starship) {
        return this.createStarshipRepositoryPort.execute(starship);
    }
}
