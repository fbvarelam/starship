package org.plexus.starship.infrastructure.kafka.adapters;

import lombok.extern.slf4j.Slf4j;
import org.plexus.starship.domain.ports.out.ConsumeStarshipRepositoryPort;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StarshipConsumerAdapter implements ConsumeStarshipRepositoryPort {

    @KafkaListener(topics = "#{'${kafka.starship.topic}'}", groupId = "#{'${kafka.group-id}'}")
    public void execute(final String message) {
        log.info("Received message: {}", message);
    }
}