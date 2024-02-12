package com.oriedroc.systems.restaurant.service.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public RestaurantDomainService paymentDomainService() {
        return new RestaurantDomainServiceImpl();
    }
}
