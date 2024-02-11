package com.oriedroc.systems.restaurant.service.domain.valueobject;

import com.oriedroc.systems.domain.valueobject.BaseId;

import java.util.UUID;

public class OrderApprovalId extends BaseId<UUID> {
    public OrderApprovalId(UUID value) {
        super(value);
    }
}
