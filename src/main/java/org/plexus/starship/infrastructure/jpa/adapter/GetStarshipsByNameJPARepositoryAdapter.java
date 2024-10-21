package org.plexus.starship.infrastructure.jpa.adapter;

import org.plexus.starship.domain.Starship;
import org.plexus.starship.domain.ports.out.StarshipsByNameRepositoryPort;
import org.plexus.starship.infrastructure.jpa.mapper.JPARepositoryMapper;
import org.plexus.starship.infrastructure.jpa.repositories.StarshipJPARepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetStarshipsByNameJPARepositoryAdapter implements StarshipsByNameRepositoryPort {

    private final StarshipJPARepository starshipJPARepository;
    private final JPARepositoryMapper jpaRepositoryMapper;

    public GetStarshipsByNameJPARepositoryAdapter(StarshipJPARepository starshipJPARepository, JPARepositoryMapper jpaRepositoryMapper) {
        this.starshipJPARepository = starshipJPARepository;
        this.jpaRepositoryMapper = jpaRepositoryMapper;
    }

    @Override
    public List<Starship> execute(String name) {
        return this.starshipJPARepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(this.jpaRepositoryMapper::toDomain)
                .toList();
    }
}
