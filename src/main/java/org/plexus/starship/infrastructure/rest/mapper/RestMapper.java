package org.plexus.starship.infrastructure.rest.mapper;

import org.mapstruct.Mapper;
import org.openapitools.model.StarshipRequest;
import org.openapitools.model.StarshipResponse;
import org.plexus.starship.domain.Starship;

@Mapper(componentModel = "spring")
public abstract class RestMapper {

    public abstract Starship toDomain(final StarshipRequest request);

    public abstract StarshipResponse toResponse(final Starship starship);
}
