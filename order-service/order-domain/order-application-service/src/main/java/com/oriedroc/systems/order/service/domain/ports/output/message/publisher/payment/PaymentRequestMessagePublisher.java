package com.oriedroc.systems.order.service.domain.ports.output.message.publisher.payment;

import com.oriedroc.systems.order.service.domain.outbox.model.payment.OrderPaymentOutboxMessage;
import com.oriedroc.systems.outbox.OutboxStatus;

import java.util.function.BiConsumer;

public interface PaymentRequestMessagePublisher {
    void publish(OrderPaymentOutboxMessage orderPaymentOutboxMessage,
                 BiConsumer<OrderPaymentOutboxMessage, OutboxStatus> outboxCallback);
}
