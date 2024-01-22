package com.oriedroc.systems.order.service.domain.valueobject;

import com.oriedroc.systems.domain.valueobject.BaseId;

public class OrderItemId extends BaseId<Long> {
    protected OrderItemId(Long value) {
        super(value);
    }
}
