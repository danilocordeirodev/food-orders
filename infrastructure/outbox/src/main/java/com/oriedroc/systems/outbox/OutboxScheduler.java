package com.oriedroc.systems.outbox;

public interface OutboxScheduler {
    void processOutboxMessage();
}
