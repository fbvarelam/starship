package org.plexus.starship.application.usecases;

import org.plexus.starship.domain.Starship;
import org.plexus.starship.domain.ports.in.NotifyStarshipPort;
import org.plexus.starship.domain.ports.out.NotifyStarshipRepositoryPort;

public class NotifyStarshipPortUseCase implements NotifyStarshipPort {

    private final NotifyStarshipRepositoryPort notifyStarshipRepositoryPort;

    public NotifyStarshipPortUseCase(NotifyStarshipRepositoryPort notifyStarshipRepositoryPort) {
        this.notifyStarshipRepositoryPort = notifyStarshipRepositoryPort;
    }

    @Override
    public Starship execute(final Starship starship) {

        return notifyStarshipRepositoryPort.execute(starship);
    }
}
