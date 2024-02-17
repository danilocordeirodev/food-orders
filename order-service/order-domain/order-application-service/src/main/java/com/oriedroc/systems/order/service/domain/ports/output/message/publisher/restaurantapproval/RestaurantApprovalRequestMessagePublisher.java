package com.oriedroc.systems.order.service.domain.ports.output.message.publisher.restaurantapproval;

import com.oriedroc.systems.order.service.domain.outbox.model.approval.OrderApprovalOutboxMessage;
import com.oriedroc.systems.outbox.OutboxStatus;

import java.util.function.BiConsumer;

public interface RestaurantApprovalRequestMessagePublisher {
    void publish(OrderApprovalOutboxMessage orderApprovalOutboxMessage,
                 BiConsumer<OrderApprovalOutboxMessage, OutboxStatus> outboxCallback);
}
