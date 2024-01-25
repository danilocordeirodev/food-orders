package com.oriedroc.systems.order.service.domain.entity;

import com.oriedroc.systems.domain.entity.AggregateRoot;
import com.oriedroc.systems.domain.valueobject.CustomerId;

public class Customer extends AggregateRoot<CustomerId> {
    public Customer() {
    }

    public Customer(CustomerId customerId) {
        super.setId(customerId);
    }

}
