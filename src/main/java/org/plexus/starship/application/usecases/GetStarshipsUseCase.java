package org.plexus.starship.application.usecases;

import org.plexus.starship.domain.Starship;
import org.plexus.starship.domain.ports.in.GetStarshipsPort;
import org.plexus.starship.domain.ports.out.StarshipsRepositoryPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class GetStarshipsUseCase implements GetStarshipsPort {

    private final StarshipsRepositoryPort starshipsRepositoryPort;

    public GetStarshipsUseCase(StarshipsRepositoryPort starshipsRepositoryPort) {
        this.starshipsRepositoryPort = starshipsRepositoryPort;
    }


    @Override
    public Page<Starship> execute(final Pageable pageable) {
        return this.starshipsRepositoryPort.execute(pageable);
    }
}
