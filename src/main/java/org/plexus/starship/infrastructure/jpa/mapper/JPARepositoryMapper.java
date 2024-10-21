package org.plexus.starship.infrastructure.jpa.mapper;

import org.mapstruct.Mapper;
import org.plexus.starship.domain.Starship;
import org.plexus.starship.infrastructure.jpa.model.StarshipEntity;

@Mapper(componentModel = "spring")
public abstract class JPARepositoryMapper {

    public abstract Starship toDomain(final StarshipEntity entity);

    public abstract StarshipEntity toEntity(final Starship starship);
}
