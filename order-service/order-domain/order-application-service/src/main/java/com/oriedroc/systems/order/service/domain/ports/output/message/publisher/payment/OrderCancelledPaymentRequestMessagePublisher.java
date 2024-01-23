package com.oriedroc.systems.order.service.domain.ports.output.message.publisher.payment;

import com.oriedroc.systems.domain.event.publisher.DomainEventPublisher;
import com.oriedroc.systems.order.service.domain.event.OrderCancelledEvent;
import com.oriedroc.systems.order.service.domain.event.OrderCreatedEvent;

public interface OrderCancelledPaymentRequestMessagePublisher extends DomainEventPublisher<OrderCancelledEvent> {
}
