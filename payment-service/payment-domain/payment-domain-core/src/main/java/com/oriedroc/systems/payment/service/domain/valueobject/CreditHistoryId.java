package com.oriedroc.systems.payment.service.domain.valueobject;

import com.oriedroc.systems.domain.valueobject.BaseId;

import java.util.UUID;

public class CreditHistoryId extends BaseId<UUID> {

    public CreditHistoryId(UUID value) {
        super(value);
    }
}
