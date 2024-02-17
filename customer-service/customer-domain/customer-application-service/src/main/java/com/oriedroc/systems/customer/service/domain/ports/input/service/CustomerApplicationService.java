package com.oriedroc.systems.customer.service.domain.ports.input.service;

import com.oriedroc.systems.customer.service.domain.create.CreateCustomerCommand;
import com.oriedroc.systems.customer.service.domain.create.CreateCustomerResponse;
import jakarta.validation.Valid;


public interface CustomerApplicationService {

    CreateCustomerResponse createCustomer(@Valid CreateCustomerCommand createCustomerCommand);

}
