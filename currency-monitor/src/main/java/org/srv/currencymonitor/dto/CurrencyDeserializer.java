package org.srv.currencymonitor.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.stereotype.Component;
import org.srv.currencymonitor.model.Currency;

import java.io.IOException;
import java.util.List;

@Component
public class CurrencyDeserializer<T> implements Deserializer<T> {

    private final ObjectMapper objectMapper;
    public CurrencyDeserializer() {
        this.objectMapper = new ObjectMapper()
                .setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    }

    @Override
    public T deserialize(String topic, byte[] bytes) {
        try {
            return objectMapper.readValue(
                    new String(bytes),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Currency.class)
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
