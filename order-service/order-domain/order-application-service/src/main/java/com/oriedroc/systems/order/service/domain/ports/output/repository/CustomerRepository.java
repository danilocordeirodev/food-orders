package com.oriedroc.systems.order.service.domain.ports.output.repository;

import com.oriedroc.systems.order.service.domain.entity.Customer;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {
    Optional<Customer> findCustomer(UUID customerId);
}
