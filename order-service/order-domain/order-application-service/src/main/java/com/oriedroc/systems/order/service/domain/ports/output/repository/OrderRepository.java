package com.oriedroc.systems.order.service.domain.ports.output.repository;

import com.oriedroc.systems.domain.valueobject.OrderId;
import com.oriedroc.systems.order.service.domain.entity.Order;
import com.oriedroc.systems.order.service.domain.valueobject.TrackingId;

import java.util.Optional;

public interface OrderRepository {
    Order save(Order order);

    Optional<Order> findById(OrderId orderId);
    Optional<Order> findByTrackingId(TrackingId trackingId);
}
