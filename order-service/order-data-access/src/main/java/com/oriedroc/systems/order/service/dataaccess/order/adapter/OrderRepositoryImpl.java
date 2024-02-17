package com.oriedroc.systems.order.service.dataaccess.order.adapter;

import com.oriedroc.systems.domain.valueobject.OrderId;
import com.oriedroc.systems.order.service.dataaccess.order.mapper.OrderDataAccessMapper;
import com.oriedroc.systems.order.service.dataaccess.order.repository.OrderJpaRepository;
import com.oriedroc.systems.order.service.domain.entity.Order;
import com.oriedroc.systems.order.service.domain.ports.output.repository.OrderRepository;
import com.oriedroc.systems.order.service.domain.valueobject.TrackingId;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;
    private final OrderDataAccessMapper orderDataAccessMapper;

    public OrderRepositoryImpl(OrderJpaRepository orderJpaRepository, OrderDataAccessMapper orderDataAccessMapper) {
        this.orderJpaRepository = orderJpaRepository;
        this.orderDataAccessMapper = orderDataAccessMapper;
    }

    @Override
    public Order save(Order order) {
        return orderDataAccessMapper.orderEntityToOrder(orderJpaRepository
                .save(orderDataAccessMapper.orderToOrderEntity(order)));
    }

    @Override
    public Optional<Order> findById(OrderId orderId) {
        return orderJpaRepository.findById(orderId.getValue()).map(orderDataAccessMapper::orderEntityToOrder);
    }

    @Override
    public Optional<Order> findByTrackingId(TrackingId trackingId) {
        return orderJpaRepository.findByTrackingId(trackingId.getValue())
                .map(orderDataAccessMapper::orderEntityToOrder);
    }
}
