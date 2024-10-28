package org.plexus.starship.infrastructure.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.openapitools.model.StarshipResponse;
import org.plexus.starship.domain.Starship;
import org.plexus.starship.infrastructure.rest.model.StarshipRequest;

@Mapper(componentModel = "spring")
public abstract class RestMapper {

    public abstract Starship toDomain(final StarshipRequest request);

    @Mapping(target = "id", source = "id", qualifiedByName = "mapIdIfNotZero")
    public abstract StarshipResponse toResponse(final Starship starship);

    @Named("mapIdIfNotZero")
    Integer mapIdIfNotZero(final int id) {
        return id == 0 ? null : id;
    }
}
