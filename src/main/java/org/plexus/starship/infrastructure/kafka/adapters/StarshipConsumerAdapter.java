package org.plexus.starship.infrastructure.kafka.adapters;

import org.plexus.starship.domain.Starship;
import org.plexus.starship.domain.ports.out.ConsumeStarshipRepositoryPort;
import org.plexus.starship.domain.ports.out.NewStarshipRepositoryPort;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class StarshipConsumerAdapter implements ConsumeStarshipRepositoryPort {

    private final NewStarshipRepositoryPort newBookingSearchPort;

    public StarshipConsumerAdapter(NewStarshipRepositoryPort newBookingSearchPort) {
        this.newBookingSearchPort = newBookingSearchPort;
    }

    @KafkaListener(topics = "#{'${kafka.create.starship.topic}'}", groupId = "#{'${kafka.group-id}'}")
    public Starship execute(final Starship starship) {
        return newBookingSearchPort.execute(starship);
    }
}