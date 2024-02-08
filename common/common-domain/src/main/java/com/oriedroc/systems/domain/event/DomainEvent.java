package com.oriedroc.systems.domain.event;

public interface DomainEvent <T> {
    void fire();
}
