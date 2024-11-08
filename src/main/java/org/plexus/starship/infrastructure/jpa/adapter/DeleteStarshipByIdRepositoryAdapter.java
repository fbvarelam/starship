package org.plexus.starship.infrastructure.jpa.adapter;

import org.plexus.starship.domain.exceptions.StarshipNotFoundException;
import org.plexus.starship.domain.ports.out.DeleteStarshipByIdRepositoryPort;
import org.plexus.starship.infrastructure.jpa.repositories.StarshipJPARepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteStarshipByIdRepositoryAdapter implements DeleteStarshipByIdRepositoryPort {

    private final StarshipJPARepository starshipJPARepository;

    public DeleteStarshipByIdRepositoryAdapter(final StarshipJPARepository starshipJPARepository) {
        this.starshipJPARepository = starshipJPARepository;
    }

    @Override
    public void execute(final long id) throws StarshipNotFoundException {
        var starshipEntity = this.starshipJPARepository.findById(id)
                .orElseThrow(() -> new StarshipNotFoundException("Starship not found"));

        this.starshipJPARepository.deleteById(starshipEntity.getId());
    }
}
