package com.oriedroc.systems.restaurant.service.domain.ports.input.message.listener;

import com.oriedroc.systems.restaurant.service.domain.dto.RestaurantApprovalRequest;

public interface RestaurantApprovalRequestMessageListener {
    void approveOrder(RestaurantApprovalRequest restaurantApprovalRequest);
}
