package org.plexus.starship.domain.ports.in;

import org.plexus.starship.infrastructure.jpa.model.Starship;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GetStarshipsPort {
    Page<Starship> execute(final Pageable pageable);
}
