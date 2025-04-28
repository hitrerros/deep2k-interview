package org.srv.contentadm.configuration;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.srv.contentadm.dto.GenericSerializer;

import java.util.Properties;

@Configuration
public class KafkaConfiguration {
    @Bean
    public KafkaProducer<String, byte[]> videoProducer() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");
        return new KafkaProducer<>(props);
    }
    @Bean
    public<T> KafkaProducer<String, T> genericProducer() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", GenericSerializer.class.getName());
        return new KafkaProducer<>(props);
    }
}
