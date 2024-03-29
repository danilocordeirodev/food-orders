package com.oriedroc.systems.order.service.dataaccess.customer.mapper;

import com.oriedroc.systems.domain.valueobject.CustomerId;
import com.oriedroc.systems.order.service.dataaccess.customer.entity.CustomerEntity;
import com.oriedroc.systems.order.service.domain.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDataAccessMapper {

    public Customer customerEntityToCustomer(CustomerEntity customerEntity) {
        return new Customer(new CustomerId(customerEntity.getId()));
    }

    public CustomerEntity customerToCustomerEntity(Customer customer) {
        return CustomerEntity.builder()
                .id(customer.getId().getValue())
                .username(customer.getUsername())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .build();
    }
}
