package org.srv.contentadm.configuration;


import org.apache.kafka.common.serialization.ByteArraySerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.srv.contentadm.dto.GenericSerializer;

import java.util.HashMap;
import java.util.Map;

import static org.apache.kafka.clients.producer.ProducerConfig.*;

@Configuration
public class KafkaConfiguration {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Bean
    public ProducerFactory<String, byte[]> byteArrayProducerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        config.put(KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(VALUE_SERIALIZER_CLASS_CONFIG, ByteArraySerializer.class);
        return new DefaultKafkaProducerFactory<>(config);
    }

    @Bean(name = "byteArrayKafkaTemplate")
    public KafkaTemplate<String, byte[]> byteArrayKafkaTemplate() {
        return new KafkaTemplate<>(byteArrayProducerFactory());
    }

    @Bean
    public<T> ProducerFactory<String, T> genericProducerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(BOOTSTRAP_SERVERS_CONFIG,bootstrapServers);
        config.put(KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(VALUE_SERIALIZER_CLASS_CONFIG, GenericSerializer.class.getName());

        return new DefaultKafkaProducerFactory<>(config);
    }

    @Bean(name = "genericKafkaTemplate")
    public <T> KafkaTemplate<String, T> genericKafkaTemplate() {
        return new KafkaTemplate<>(genericProducerFactory());
    }
}
