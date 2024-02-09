package com.oriedroc.systems.payment.service.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.oriedroc.systems.payment.service.dataaccess")
@EntityScan(basePackages = "com.oriedroc.systems.payment.service.dataaccess")
@SpringBootApplication(scanBasePackages = "com.oriedroc.systems")
public class PaymentServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentServiceApplication.class, args);
    }
}
