package com.oriedroc.systems.customer.service.domain;


import com.oriedroc.systems.customer.service.domain.entity.Customer;
import com.oriedroc.systems.customer.service.domain.event.CustomerCreatedEvent;

public interface CustomerDomainService {

    CustomerCreatedEvent validateAndInitiateCustomer(Customer customer);

}
