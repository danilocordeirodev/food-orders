package com.oriedroc.systems.saga;

import com.oriedroc.systems.domain.event.DomainEvent;

public interface SagaStep <T, S extends DomainEvent, U extends DomainEvent> {
    S process(T data);
    U rollback(T data);
}
