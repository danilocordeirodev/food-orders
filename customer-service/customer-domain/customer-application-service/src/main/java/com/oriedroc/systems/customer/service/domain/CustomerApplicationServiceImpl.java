package com.oriedroc.systems.customer.service.domain;

import com.oriedroc.systems.customer.service.domain.create.CreateCustomerCommand;
import com.oriedroc.systems.customer.service.domain.create.CreateCustomerResponse;
import com.oriedroc.systems.customer.service.domain.event.CustomerCreatedEvent;
import com.oriedroc.systems.customer.service.domain.mapper.CustomerDataMapper;
import com.oriedroc.systems.customer.service.domain.ports.input.service.CustomerApplicationService;
import com.oriedroc.systems.customer.service.domain.ports.output.message.publisher.CustomerMessagePublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
class CustomerApplicationServiceImpl implements CustomerApplicationService {

    private final CustomerCreateCommandHandler customerCreateCommandHandler;

    private final CustomerDataMapper customerDataMapper;

    private final CustomerMessagePublisher customerMessagePublisher;

    public CustomerApplicationServiceImpl(CustomerCreateCommandHandler customerCreateCommandHandler,
                                          CustomerDataMapper customerDataMapper,
                                          CustomerMessagePublisher customerMessagePublisher) {
        this.customerCreateCommandHandler = customerCreateCommandHandler;
        this.customerDataMapper = customerDataMapper;
        this.customerMessagePublisher = customerMessagePublisher;
    }

    @Override
    public CreateCustomerResponse createCustomer(CreateCustomerCommand createCustomerCommand) {
        CustomerCreatedEvent customerCreatedEvent = customerCreateCommandHandler.createCustomer(createCustomerCommand);
        customerMessagePublisher.publish(customerCreatedEvent);
        return customerDataMapper
                .customerToCreateCustomerResponse(customerCreatedEvent.getCustomer(),
                        "Customer saved successfully!");
    }
}
