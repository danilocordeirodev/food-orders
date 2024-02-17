package com.oriedroc.systems.restaurant.service.domain.ports.output.message.publisher;


import com.oriedroc.systems.outbox.OutboxStatus;
import com.oriedroc.systems.restaurant.service.domain.outbox.model.OrderOutboxMessage;

import java.util.function.BiConsumer;

public interface RestaurantApprovalResponseMessagePublisher {

    void publish(OrderOutboxMessage orderOutboxMessage,
                 BiConsumer<OrderOutboxMessage, OutboxStatus> outboxCallback);
}
