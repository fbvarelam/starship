package org.plexus.starship.application.usecases;

import org.plexus.starship.domain.exceptions.StarshipNotFoundException;
import org.plexus.starship.domain.ports.in.DeleteStarshipByIdPort;
import org.plexus.starship.domain.ports.out.DeleteStarshipByIdRepositoryPort;

public class DeleteStarshipByIdUseCase implements DeleteStarshipByIdPort {

    public final DeleteStarshipByIdRepositoryPort deleteStarshipByIdRepositoryPort;

    public DeleteStarshipByIdUseCase(final DeleteStarshipByIdRepositoryPort deleteStarshipByIdRepositoryPort) {
        this.deleteStarshipByIdRepositoryPort = deleteStarshipByIdRepositoryPort;
    }


    @Override
    public void execute(final long id) throws StarshipNotFoundException {
        this.deleteStarshipByIdRepositoryPort.execute(id);
    }
}
