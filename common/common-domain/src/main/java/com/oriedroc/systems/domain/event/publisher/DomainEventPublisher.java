package com.oriedroc.systems.domain.event.publisher;

import com.oriedroc.systems.domain.event.DomainEvent;

public interface DomainEventPublisher<T extends DomainEvent> {
    void publish(T domainEvent);
}
