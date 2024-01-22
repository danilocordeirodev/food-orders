package com.oriedroc.systems.domain.valueobject;

import java.util.UUID;

public class ProductId extends BaseId<UUID>{
    protected ProductId(UUID value) {
        super(value);
    }
}
