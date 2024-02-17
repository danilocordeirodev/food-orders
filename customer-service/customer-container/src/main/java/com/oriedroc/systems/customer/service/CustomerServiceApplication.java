package com.oriedroc.systems.customer.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"com.oriedroc.systems.customer.service.dataaccess", "com.oriedroc.systems.dataaccess"})
@EntityScan(basePackages = {"com.oriedroc.systems.customer.service.dataaccess", "com.oriedroc.systems.dataaccess"})
@SpringBootApplication(scanBasePackages = "com.oriedroc.systems")
public class CustomerServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
}
