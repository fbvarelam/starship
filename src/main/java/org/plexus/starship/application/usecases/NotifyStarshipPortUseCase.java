package org.plexus.starship.application.usecases;

import org.plexus.starship.domain.ports.in.NotifyStarshipPort;
import org.plexus.starship.domain.ports.out.NotifyStarshipRepositoryPort;

public class NotifyStarshipPortUseCase implements NotifyStarshipPort {

    private final NotifyStarshipRepositoryPort notifyStarshipRepositoryPort;

    public NotifyStarshipPortUseCase(final NotifyStarshipRepositoryPort notifyStarshipRepositoryPort) {
        this.notifyStarshipRepositoryPort = notifyStarshipRepositoryPort;
    }

    @Override
    public void execute(final String message) {
        this.notifyStarshipRepositoryPort.execute(message);
    }
}
