package com.oriedroc.systems.payment.service.domain.valueobject;

import com.oriedroc.systems.domain.valueobject.BaseId;

import java.util.UUID;

public class PaymentId extends BaseId<UUID> {
    public PaymentId(UUID value) {
        super(value);
    }
}
