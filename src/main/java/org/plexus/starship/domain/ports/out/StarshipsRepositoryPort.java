package org.plexus.starship.domain.ports.out;

import org.plexus.starship.domain.Starship;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StarshipsRepositoryPort {
    Page<Starship> execute(Pageable pageable);
}
