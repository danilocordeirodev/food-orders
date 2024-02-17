package com.oriedroc.systems.order.service.domain.ports.input.message.listener.customer;

import com.oriedroc.systems.order.service.domain.dto.message.CustomerModel;

public interface CustomerMessageListener {
    void customerCreated(CustomerModel customerModel);
}
