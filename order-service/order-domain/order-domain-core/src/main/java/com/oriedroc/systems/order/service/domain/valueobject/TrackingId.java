package com.oriedroc.systems.order.service.domain.valueobject;

import com.oriedroc.systems.domain.valueobject.BaseId;

import java.util.UUID;

public class TrackingId extends BaseId<UUID> {
    public TrackingId(UUID value) {
        super(value);
    }
}
