package com.oriedroc.systems.customer.service.domain.mapper;

import com.oriedroc.systems.customer.service.domain.create.CreateCustomerCommand;
import com.oriedroc.systems.customer.service.domain.create.CreateCustomerResponse;
import com.oriedroc.systems.customer.service.domain.entity.Customer;
import com.oriedroc.systems.domain.valueobject.CustomerId;
import org.springframework.stereotype.Component;

@Component
public class CustomerDataMapper {

    public Customer createCustomerCommandToCustomer(CreateCustomerCommand createCustomerCommand) {
        return new Customer(new CustomerId(createCustomerCommand.getCustomerId()),
                createCustomerCommand.getUsername(),
                createCustomerCommand.getFirstName(),
                createCustomerCommand.getLastName());
    }

    public CreateCustomerResponse customerToCreateCustomerResponse(Customer customer, String message) {
        return new CreateCustomerResponse(customer.getId().getValue(), message);
    }
}
