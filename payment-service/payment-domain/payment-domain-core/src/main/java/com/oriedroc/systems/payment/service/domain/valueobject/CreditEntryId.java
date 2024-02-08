package com.oriedroc.systems.payment.service.domain.valueobject;

import com.oriedroc.systems.domain.valueobject.BaseId;

import java.util.UUID;

public class CreditEntryId extends BaseId<UUID> {

    public CreditEntryId(UUID value) {
        super(value);
    }
}
