package com.oriedroc.systems.order.service.domain.ports.output.message.publisher.restaurantapproval;

import com.oriedroc.systems.domain.event.publisher.DomainEventPublisher;
import com.oriedroc.systems.order.service.domain.event.OrderPaidEvent;

public interface OrderPaidRestaurantRequestMessagePublisher extends DomainEventPublisher<OrderPaidEvent> {
}
