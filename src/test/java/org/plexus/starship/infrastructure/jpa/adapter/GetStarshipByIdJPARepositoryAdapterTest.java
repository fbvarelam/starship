package org.plexus.starship.infrastructure.jpa.adapter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.plexus.starship.domain.Starship;
import org.plexus.starship.infrastructure.jpa.mapper.JPARepositoryMapper;
import org.plexus.starship.infrastructure.jpa.model.StarshipEntity;
import org.plexus.starship.infrastructure.jpa.repositories.StarshipJPARepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetStarshipByIdJPARepositoryAdapterTest {

    @Mock
    private StarshipJPARepository starshipJPARepository;

    @Mock
    private JPARepositoryMapper jpaRepositoryMapper;

    @InjectMocks
    private GetStarshipByIdJPARepositoryAdapter getStarshipByIdJPARepositoryAdapter;

    @Test
    void whenExecuteThenReturnStarshipOK() {

        when(this.starshipJPARepository.findById(anyLong()))
                .thenReturn(Optional.of(new StarshipEntity()));
        when(this.jpaRepositoryMapper.toDomain(any(StarshipEntity.class)))
                .thenReturn(new Starship(1, "name", "model"));

        var result = this.getStarshipByIdJPARepositoryAdapter.execute(1);

        assertNotNull(result);
        assertEquals(1, result.get().id());
        assertEquals("name", result.get().name());
        assertEquals("model", result.get().type());
    }
}