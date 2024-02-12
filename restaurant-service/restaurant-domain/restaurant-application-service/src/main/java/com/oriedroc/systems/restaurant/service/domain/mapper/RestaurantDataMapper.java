package com.oriedroc.systems.restaurant.service.domain.mapper;

import com.oriedroc.systems.domain.valueobject.Money;
import com.oriedroc.systems.domain.valueobject.OrderId;
import com.oriedroc.systems.domain.valueobject.OrderStatus;
import com.oriedroc.systems.domain.valueobject.RestaurantId;
import com.oriedroc.systems.restaurant.service.domain.dto.RestaurantApprovalRequest;
import com.oriedroc.systems.restaurant.service.domain.entity.OrderDetail;
import com.oriedroc.systems.restaurant.service.domain.entity.Product;
import com.oriedroc.systems.restaurant.service.domain.entity.Restaurant;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class RestaurantDataMapper {
    public Restaurant restaurantApprovalRequestToRestaurant(RestaurantApprovalRequest
                                                                             restaurantApprovalRequest) {
        return Restaurant.builder()
                .restaurantId(new RestaurantId(UUID.fromString(restaurantApprovalRequest.getRestaurantId())))
                .orderDetail(OrderDetail.builder()
                        .orderId(new OrderId(UUID.fromString(restaurantApprovalRequest.getOrderId())))
                        .products(restaurantApprovalRequest.getProducts().stream().map(
                                product -> Product.builder()
                                        .productId(product.getId())
                                        .quantity(product.getQuantity())
                                        .build())
                                .collect(Collectors.toList()))
                        .totalAmount(new Money(restaurantApprovalRequest.getPrice()))
                        .orderStatus(OrderStatus.valueOf(restaurantApprovalRequest.getRestaurantOrderStatus().name()))
                        .build())
                .build();

    }
}
