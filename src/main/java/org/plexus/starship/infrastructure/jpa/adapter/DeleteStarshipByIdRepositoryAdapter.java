package org.plexus.starship.infrastructure.jpa.adapter;

import org.plexus.starship.domain.ports.out.DeleteStarshipByIdRepositoryPort;
import org.plexus.starship.infrastructure.jpa.repositories.StarshipJPARepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteStarshipByIdRepositoryAdapter implements DeleteStarshipByIdRepositoryPort {

    private final StarshipJPARepository starshipJPARepository;

    public DeleteStarshipByIdRepositoryAdapter(StarshipJPARepository starshipJPARepository) {
        this.starshipJPARepository = starshipJPARepository;
    }

    @Override
    public void execute(long id) {
        starshipJPARepository.deleteById(id);
    }
}
