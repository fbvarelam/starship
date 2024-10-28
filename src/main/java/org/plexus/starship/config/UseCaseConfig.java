package org.plexus.starship.config;

import org.plexus.starship.application.usecases.DeleteStarshipByIdUseCase;
import org.plexus.starship.application.usecases.GetStarshipByIdUseCase;
import org.plexus.starship.application.usecases.GetStarshipsByNamePortUseCase;
import org.plexus.starship.application.usecases.GetStarshipsUseCase;
import org.plexus.starship.application.usecases.NewStarshipUseCase;
import org.plexus.starship.application.usecases.NotifyStarshipPortUseCase;
import org.plexus.starship.application.usecases.UpdateStarshipByIdUseCase;
import org.plexus.starship.domain.ports.in.DeleteStarshipByIdPort;
import org.plexus.starship.domain.ports.in.GetStarshipByIdPort;
import org.plexus.starship.domain.ports.in.GetStarshipsByNamePort;
import org.plexus.starship.domain.ports.in.GetStarshipsPort;
import org.plexus.starship.domain.ports.in.NewStarshipPort;
import org.plexus.starship.domain.ports.in.NotifyStarshipPort;
import org.plexus.starship.domain.ports.in.UpdateStarshipByIdPort;
import org.plexus.starship.domain.ports.out.DeleteStarshipByIdRepositoryPort;
import org.plexus.starship.domain.ports.out.NewStarshipRepositoryPort;
import org.plexus.starship.domain.ports.out.NotifyStarshipRepositoryPort;
import org.plexus.starship.domain.ports.out.StarshipByIdRepositoryPort;
import org.plexus.starship.domain.ports.out.StarshipsByNameRepositoryPort;
import org.plexus.starship.domain.ports.out.StarshipsRepositoryPort;
import org.plexus.starship.domain.ports.out.UpdateStarshipRepositoryPort;
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
    public NewStarshipPort createStarshipPort(final NewStarshipRepositoryPort newStarshipRepositoryPort) {
        return new NewStarshipUseCase(newStarshipRepositoryPort);
    }

    @Bean
    public UpdateStarshipByIdPort updateStarshipByIdPort(final UpdateStarshipRepositoryPort updateStarshipRepositoryPort) {
        return new UpdateStarshipByIdUseCase(updateStarshipRepositoryPort);
    }

    @Bean
    public GetStarshipsByNamePort getStarshipsByNamePort(final StarshipsByNameRepositoryPort starshipsByNameRepositoryPort) {
        return new GetStarshipsByNamePortUseCase(starshipsByNameRepositoryPort);
    }

    @Bean
    public NotifyStarshipPort notifyStarshipPortUseCase(final NotifyStarshipRepositoryPort notifyStarshipRepositoryPort) {
        return new NotifyStarshipPortUseCase(notifyStarshipRepositoryPort);
    }
}
