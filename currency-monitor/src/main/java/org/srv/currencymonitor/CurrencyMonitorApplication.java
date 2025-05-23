package org.srv.currencymonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class CurrencyMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyMonitorApplication.class, args);
    }

}
