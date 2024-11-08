package org.plexus.starship.application.usecases;

import org.plexus.starship.domain.Starship;
import org.plexus.starship.domain.ports.in.GetStarshipsByNamePort;
import org.plexus.starship.domain.ports.out.StarshipsByNameRepositoryPort;

import java.util.List;

public class GetStarshipsByNamePortUseCase implements GetStarshipsByNamePort {

    private final StarshipsByNameRepositoryPort starshipsByNameRepositoryPort;

    public GetStarshipsByNamePortUseCase(final StarshipsByNameRepositoryPort starshipsByNameRepositoryPort) {
        this.starshipsByNameRepositoryPort = starshipsByNameRepositoryPort;
    }

    @Override
    public List<Starship> execute(final String name) {
        return this.starshipsByNameRepositoryPort.execute(name);
    }
}
