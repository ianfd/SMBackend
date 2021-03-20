package de.craftedcrime.infrastructure.servermanagerwe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ServermanagerweApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServermanagerweApplication.class, args);
    }

}
