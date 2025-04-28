package org.srv.currencymonitor.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;
import org.srv.currencymonitor.model.Currency;

import java.io.IOException;
import java.util.List;

public class CurrencyDeserializer<T> implements Deserializer<T> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public T deserialize(String topic, byte[] bytes) {
        try {
            return objectMapper.readValue(
                    bytes,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Currency.class)
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
