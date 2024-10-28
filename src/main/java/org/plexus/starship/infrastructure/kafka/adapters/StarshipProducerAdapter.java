package org.plexus.starship.infrastructure.kafka.adapters;

import org.plexus.starship.domain.Starship;
import org.plexus.starship.domain.ports.out.NotifyStarshipRepositoryPort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class StarshipProducerAdapter implements NotifyStarshipRepositoryPort {

    private final KafkaTemplate<String, Starship> kafkaTemplate;

    @Value("${kafka.create.starship.topic}")
    private String topic;

    public StarshipProducerAdapter(KafkaTemplate<String, Starship> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public Starship execute(Starship starship) {
        kafkaTemplate.send(topic, starship);
        return starship;

    }
}

