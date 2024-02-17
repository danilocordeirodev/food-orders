package com.oriedroc.systems.customer.service;

import com.oriedroc.systems.customer.service.domain.CustomerDomainService;
import com.oriedroc.systems.customer.service.domain.CustomerDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CustomerDomainService customerDomainService() {
        return new CustomerDomainServiceImpl();
    }
}
