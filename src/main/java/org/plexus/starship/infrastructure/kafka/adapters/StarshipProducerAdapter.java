package org.plexus.starship.infrastructure.kafka.adapters;

import org.plexus.starship.domain.ports.out.NotifyStarshipRepositoryPort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class StarshipProducerAdapter implements NotifyStarshipRepositoryPort {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.starship.topic}")
    private String topic;

    public StarshipProducerAdapter(final KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void execute(final String message) {
        this.kafkaTemplate.send(this.topic, message);
    }
}