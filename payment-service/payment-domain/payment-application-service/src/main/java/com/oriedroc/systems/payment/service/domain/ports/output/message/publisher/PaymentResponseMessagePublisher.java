package com.oriedroc.systems.payment.service.domain.ports.output.message.publisher;


import com.oriedroc.systems.outbox.OutboxStatus;
import com.oriedroc.systems.payment.service.domain.outbox.model.OrderOutboxMessage;

import java.util.function.BiConsumer;

public interface PaymentResponseMessagePublisher {
    void publish(OrderOutboxMessage orderOutboxMessage,
                 BiConsumer<OrderOutboxMessage, OutboxStatus> outboxCallback);
}
