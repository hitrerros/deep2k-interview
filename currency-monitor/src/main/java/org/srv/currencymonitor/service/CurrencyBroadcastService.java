package org.srv.currencymonitor.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.srv.currencymonitor.model.Currency;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class CurrencyBroadcastService {
    private final List<Currency> buffer = new CopyOnWriteArrayList<>();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "currency-content", groupId = "currency-1")
    public void consume(List<Currency> body) {
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
