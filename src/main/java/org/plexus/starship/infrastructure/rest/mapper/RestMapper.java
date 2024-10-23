package org.plexus.starship.infrastructure.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.openapitools.model.StarshipResponse;
import org.plexus.starship.domain.Starship;
import org.plexus.starship.infrastructure.rest.model.StarshipRequest;

@Mapper(componentModel = "spring")
public abstract class RestMapper {

    @Mapping(target = "id", ignore = true)
    public abstract Starship toDomain(final StarshipRequest request);

    public abstract StarshipResponse toResponse(final Starship starship);
}
