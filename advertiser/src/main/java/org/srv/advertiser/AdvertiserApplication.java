package org.srv.advertiser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class AdvertiserApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdvertiserApplication.class, args);
    }

}
