package org.plexus.starship.config;

import org.plexus.starship.application.usecases.*;
import org.plexus.starship.domain.ports.in.*;
import org.plexus.starship.domain.ports.out.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public GetStarshipByIdPort getStarshipByIdPortUseCase(final StarshipByIdRepositoryPort starshipByIdRepositoryPort) {
        return new GetStarshipByIdUseCase(starshipByIdRepositoryPort);
    }

    @Bean
    public GetStarshipsPort getStarshipsPortUseCase(final StarshipsRepositoryPort getStarshipsPort) {
        return new GetStarshipsUseCase(getStarshipsPort);
    }

    @Bean
    public DeleteStarshipByIdPort deleteStarshipByIdPort(final DeleteStarshipByIdRepositoryPort deleteStarshipByIdRepositoryPort) {
        return new DeleteStarshipByIdUseCase(deleteStarshipByIdRepositoryPort);
    }

    @Bean
    public CreateStarshipPort createStarshipPort(final CreateStarshipRepositoryPort createStarshipRepositoryPort) {
        return new CreateStarshipPortUseCase(createStarshipRepositoryPort);
    }

    @Bean
    public UpdateStarshipByIdPort updateStarshipByIdPort(final UpdateStarshipRepositoryPort updateStarshipRepositoryPort) {
        return new UpdateStarshipByIdUseCase(updateStarshipRepositoryPort);
    }

    @Bean
    public GetStarshipsByNamePort getStarshipsByNamePort(final StarshipsByNameRepositoryPort starshipsByNameRepositoryPort) {
        return new GetStarshipsByNamePortUseCase(starshipsByNameRepositoryPort);
    }
}
