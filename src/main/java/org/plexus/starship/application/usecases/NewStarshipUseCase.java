package org.plexus.starship.application.usecases;

import org.plexus.starship.domain.Starship;
import org.plexus.starship.domain.ports.in.NewStarshipPort;
import org.plexus.starship.domain.ports.out.NewStarshipRepositoryPort;

public class NewStarshipUseCase implements NewStarshipPort {

    private final NewStarshipRepositoryPort newStarshipRepositoryPort;

    public NewStarshipUseCase(NewStarshipRepositoryPort newStarshipRepositoryPort) {
        this.newStarshipRepositoryPort = newStarshipRepositoryPort;
    }

    @Override
    public Starship execute(final Starship starship) {
        return this.newStarshipRepositoryPort.execute(starship);
    }
}
