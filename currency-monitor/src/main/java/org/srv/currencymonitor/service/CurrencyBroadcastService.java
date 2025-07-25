package org.srv.currencymonitor.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.srv.currencymonitor.model.Currency;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
@Slf4j
public class CurrencyBroadcastService {
    @Autowired
    private ObjectMapper objectMapper;
    private final List<Currency> buffer = new CopyOnWriteArrayList<>();

    @KafkaListener(topics = "currency-content", groupId = "currency-1")
    public void consume(List<Currency> body) {
        log.info("Kafka consumed message {}",body.toString());
        buffer.clear();
        buffer.addAll(body);
    }

    public String retrieveCurrencyToExternalServices() {
        try {
            return objectMapper.writeValueAsString(buffer.stream().toList());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
