package org.plexus.starship.infrastructure.jpa.adapter;

import org.plexus.starship.domain.Starship;
import org.plexus.starship.domain.ports.out.UpdateStarshipRepositoryPort;
import org.plexus.starship.infrastructure.jpa.mapper.JPARepositoryMapper;
import org.plexus.starship.infrastructure.jpa.repositories.StarshipJPARepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateStarshipRepositoryAdapter implements UpdateStarshipRepositoryPort {

    private final StarshipJPARepository starshipJPARepository;
    private final JPARepositoryMapper jpaRepositoryMapper;

    public UpdateStarshipRepositoryAdapter(StarshipJPARepository starshipJPARepository, JPARepositoryMapper jpaRepositoryMapper) {
        this.starshipJPARepository = starshipJPARepository;
        this.jpaRepositoryMapper = jpaRepositoryMapper;
    }

    @Override
    public Optional<Starship> execute(final long id, final Starship starship) {

        return this.starshipJPARepository.findById(id)
                .map(starshipEntity -> {
                    starshipEntity.setName(starship.name());
                    starshipEntity.setType(starship.type());
                    return starshipEntity;

                }).map(starshipJPARepository::save)
                .map(jpaRepositoryMapper::toDomain);

    }
}
