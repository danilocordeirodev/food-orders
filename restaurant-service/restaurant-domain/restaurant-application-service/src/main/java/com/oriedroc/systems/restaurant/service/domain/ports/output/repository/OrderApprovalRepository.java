package com.oriedroc.systems.restaurant.service.domain.ports.output.repository;

import com.oriedroc.systems.restaurant.service.domain.entity.OrderApproval;

public interface OrderApprovalRepository {
    OrderApproval save(OrderApproval orderApproval);
}
