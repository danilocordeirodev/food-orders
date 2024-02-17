package com.oriedroc.systems.restaurant.service.domain;

import com.oriedroc.systems.restaurant.service.domain.entity.Restaurant;
import com.oriedroc.systems.restaurant.service.domain.event.OrderApprovalEvent;

import java.util.List;

public interface RestaurantDomainService {
    OrderApprovalEvent validateOrder(
            Restaurant restaurant,
            List<String> failureMessages
    );
}
