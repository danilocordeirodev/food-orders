package com.oriedroc.systems.restaurant.service.domain.ports.output.message.publisher;

import com.oriedroc.systems.domain.event.publisher.DomainEventPublisher;
import com.oriedroc.systems.restaurant.service.domain.event.OrderApprovedEvent;
import com.oriedroc.systems.restaurant.service.domain.event.OrderRejectedEvent;

public interface OrderRejectedMessagePublisher extends DomainEventPublisher<OrderRejectedEvent> {
}
