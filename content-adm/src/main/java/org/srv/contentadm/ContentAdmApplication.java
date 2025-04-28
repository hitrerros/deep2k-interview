package org.srv.contentadm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class ContentAdmApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContentAdmApplication.class, args);
    }

}
