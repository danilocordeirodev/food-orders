package com.oriedroc.systems.customer.service.domain.ports.output.repository;

import com.oriedroc.systems.customer.service.domain.entity.Customer;

public interface CustomerRepository {

    Customer createCustomer(Customer customer);
}
