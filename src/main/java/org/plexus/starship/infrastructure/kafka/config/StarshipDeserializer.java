package org.plexus.starship.infrastructure.kafka.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.plexus.starship.domain.Starship;

public class StarshipDeserializer implements Deserializer<Starship> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Starship deserialize(String topic, byte[] data) {
        try {
            return objectMapper.readValue(data, Starship.class);
        } catch (Exception e) {
            throw new SerializationException("Error deserializing Starship", e);
        }
    }
}
