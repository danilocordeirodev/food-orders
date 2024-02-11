package com.oriedroc.systems.restaurant.service.domain;

import com.oriedroc.systems.domain.event.publisher.DomainEventPublisher;
import com.oriedroc.systems.restaurant.service.domain.entity.Restaurant;
import com.oriedroc.systems.restaurant.service.domain.event.OrderApprovalEvent;
import com.oriedroc.systems.restaurant.service.domain.event.OrderApprovedEvent;
import com.oriedroc.systems.restaurant.service.domain.event.OrderRejectedEvent;

import java.util.List;

public interface RestaurantDomainService {
    OrderApprovalEvent validateOrder(
            Restaurant restaurant,
            List<String> failureMessages,
            DomainEventPublisher<OrderApprovedEvent> orderApprovedEventDomainEventPublisher,
            DomainEventPublisher<OrderRejectedEvent> orderRejectedEventDomainEventPublisher
    );
}
