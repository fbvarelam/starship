package org.plexus.starship;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class StarshipApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarshipApplication.class, args);
    }
}
