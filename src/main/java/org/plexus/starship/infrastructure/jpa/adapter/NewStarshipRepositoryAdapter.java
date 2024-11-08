package org.plexus.starship.infrastructure.jpa.adapter;

import org.plexus.starship.domain.Starship;
import org.plexus.starship.domain.ports.out.NewStarshipRepositoryPort;
import org.plexus.starship.infrastructure.jpa.mapper.JPARepositoryMapper;
import org.plexus.starship.infrastructure.jpa.repositories.StarshipJPARepository;
import org.springframework.stereotype.Service;

@Service
public class NewStarshipRepositoryAdapter implements NewStarshipRepositoryPort {

    private final StarshipJPARepository starshipJPARepository;
    private final JPARepositoryMapper jpaRepositoryMapper;

    public NewStarshipRepositoryAdapter(final StarshipJPARepository starshipJPARepository, final JPARepositoryMapper jpaRepositoryMapper) {
        this.starshipJPARepository = starshipJPARepository;
        this.jpaRepositoryMapper = jpaRepositoryMapper;
    }

    @Override
    public Starship execute(final Starship starship) {
        final var entity = this.jpaRepositoryMapper.toEntity(starship);
        final var starshipEntity = this.starshipJPARepository.save(entity);
        return this.jpaRepositoryMapper.toDomain(starshipEntity);
    }
}
