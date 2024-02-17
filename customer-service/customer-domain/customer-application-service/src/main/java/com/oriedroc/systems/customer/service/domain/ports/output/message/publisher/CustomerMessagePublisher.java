package com.oriedroc.systems.customer.service.domain.ports.output.message.publisher;

import com.oriedroc.systems.customer.service.domain.event.CustomerCreatedEvent;

public interface CustomerMessagePublisher {

    void publish(CustomerCreatedEvent customerCreatedEvent);

}