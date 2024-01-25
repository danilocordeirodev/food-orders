package com.oriedroc.systems.order.service.dataaccess.customer.adapter;

import com.oriedroc.systems.order.service.dataaccess.customer.mapper.CustomerDataAccessMapper;
import com.oriedroc.systems.order.service.dataaccess.customer.repository.CustomerJpaRepository;
import com.oriedroc.systems.order.service.domain.entity.Customer;
import com.oriedroc.systems.order.service.domain.ports.output.repository.CustomerRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class CutomerRepositoryImpl implements CustomerRepository {
    private final CustomerJpaRepository customerJpaRepository;
    private final CustomerDataAccessMapper customerDataAccessMapper;

    public CutomerRepositoryImpl(CustomerJpaRepository customerJpaRepository, CustomerDataAccessMapper customerDataAccessMapper) {

        this.customerJpaRepository = customerJpaRepository;
        this.customerDataAccessMapper = customerDataAccessMapper;
    }

    @Override
    public Optional<Customer> findCustomer(UUID customerId) {
        return customerJpaRepository.findById(customerId).map(customerDataAccessMapper::customerEntityToCustomer);
    }
}
