package org.srv.contentadm.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;

public class GenericSerializer<T> implements Serializer<T> {
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public byte[] serialize(String topic, T body) {
        try {
            return objectMapper.writeValueAsBytes(body);
        } catch (Exception e) {
            throw new RuntimeException("Error serializing JSON", e);
        }
    }
}
