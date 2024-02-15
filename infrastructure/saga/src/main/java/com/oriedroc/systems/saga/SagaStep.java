package com.oriedroc.systems.saga;

import com.oriedroc.systems.domain.event.DomainEvent;

public interface SagaStep <T> {
    void process(T data);
    void rollback(T data);
}
