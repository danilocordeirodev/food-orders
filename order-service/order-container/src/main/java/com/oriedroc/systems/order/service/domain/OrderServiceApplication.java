package com.oriedroc.systems.order.service.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.oriedroc.systems.order.service.dataaccess")
@EntityScan(basePackages = "com.oriedroc.systems.order.service.dataaccess")
@SpringBootApplication(scanBasePackages = "com.oriedroc.systems")
public class OrderServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }
}
