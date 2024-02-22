package com.reservations.reservations;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReservationsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReservationsApplication.class, args);
    }

}
