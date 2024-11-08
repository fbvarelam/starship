package org.plexus.starship.infrastructure.jpa.adapter;

import org.plexus.starship.domain.Starship;
import org.plexus.starship.domain.ports.out.StarshipByIdRepositoryPort;
import org.plexus.starship.infrastructure.jpa.mapper.JPARepositoryMapper;
import org.plexus.starship.infrastructure.jpa.repositories.StarshipJPARepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetStarshipByIdJPARepositoryAdapter implements StarshipByIdRepositoryPort {

    private final StarshipJPARepository starshipJPARepository;
    private final JPARepositoryMapper jpaRepositoryMapper;


    public GetStarshipByIdJPARepositoryAdapter(final StarshipJPARepository starshipJPARepository, final JPARepositoryMapper jpaRepositoryMapper) {
        this.starshipJPARepository = starshipJPARepository;
        this.jpaRepositoryMapper = jpaRepositoryMapper;
    }

    @Override
    public Optional<Starship> execute(final long id) {
        return this.starshipJPARepository.findById(id)
                .map(this.jpaRepositoryMapper::toDomain);
    }
}


