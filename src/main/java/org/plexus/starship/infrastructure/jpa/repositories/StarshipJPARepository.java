package org.plexus.starship.infrastructure.jpa.repositories;

import org.plexus.starship.infrastructure.jpa.model.StarshipEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface StarshipJPARepository extends CrudRepository<StarshipEntity, Long> {

    Optional<StarshipEntity> findById(long id);

    Page<StarshipEntity> findAll(Pageable pageable);

    List<StarshipEntity> findByNameContainingIgnoreCase(String name);
}
