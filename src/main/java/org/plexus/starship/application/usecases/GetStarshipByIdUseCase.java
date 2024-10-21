package org.plexus.starship.application.usecases;

import org.plexus.starship.domain.Starship;
import org.plexus.starship.domain.ports.in.GetStarshipByIdPort;
import org.plexus.starship.domain.ports.out.StarshipByIdRepositoryPort;

public class GetStarshipByIdUseCase implements GetStarshipByIdPort {

    private final StarshipByIdRepositoryPort starshipByIdRepositoryPort;

    public GetStarshipByIdUseCase(StarshipByIdRepositoryPort starshipByIdRepositoryPort) {
        this.starshipByIdRepositoryPort = starshipByIdRepositoryPort;
    }

    @Override
    public Starship execute(final long id) {
        return this.starshipByIdRepositoryPort.execute(id)
                .orElseThrow(() -> new RuntimeException("Starship not found"));
    }
}
