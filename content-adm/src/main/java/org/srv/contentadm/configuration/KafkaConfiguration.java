package org.srv.contentadm.configuration;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.srv.contentadm.dto.GenericSerializer;

import java.util.Properties;

import static org.apache.kafka.clients.producer.ProducerConfig.*;

@Configuration
public class KafkaConfiguration {
    @Bean
    public KafkaProducer<String, byte[]> videoProducer() {
        Properties props = new Properties();
        props.put(BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.ByteArraySerializer");
        return new KafkaProducer<>(props);
    }
    @Bean
    public<T> KafkaProducer<String, T> genericProducer() {
        Properties props = new Properties();
        props.put(BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(VALUE_SERIALIZER_CLASS_CONFIG, GenericSerializer.class.getName());

        return new KafkaProducer<>(props);
    }
}
