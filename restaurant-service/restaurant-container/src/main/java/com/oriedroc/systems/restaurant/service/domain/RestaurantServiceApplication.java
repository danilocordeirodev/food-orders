package com.oriedroc.systems.restaurant.service.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = { "com.oriedroc.systems.restaurant.service.dataaccess", "com.oriedroc.systems.dataaccess"})
@EntityScan(basePackages = { "com.oriedroc.systems.restaurant.service.dataaccess", "com.oriedroc.systems.dataaccess"})
@SpringBootApplication(scanBasePackages = "com.oriedroc.systems")
public class RestaurantServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestaurantServiceApplication.class, args);
    }
}
