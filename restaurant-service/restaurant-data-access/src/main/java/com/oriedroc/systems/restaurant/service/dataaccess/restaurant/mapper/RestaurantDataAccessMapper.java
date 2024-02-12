package com.oriedroc.systems.restaurant.service.dataaccess.restaurant.mapper;


import com.oriedroc.systems.dataaccess.restaurant.entity.RestaurantEntity;
import com.oriedroc.systems.dataaccess.restaurant.exception.RestaurantDataAccessException;
import com.oriedroc.systems.domain.valueobject.Money;
import com.oriedroc.systems.domain.valueobject.OrderId;
import com.oriedroc.systems.domain.valueobject.ProductId;
import com.oriedroc.systems.domain.valueobject.RestaurantId;
import com.oriedroc.systems.restaurant.service.dataaccess.restaurant.entity.OrderApprovalEntity;
import com.oriedroc.systems.restaurant.service.domain.entity.OrderApproval;
import com.oriedroc.systems.restaurant.service.domain.entity.OrderDetail;
import com.oriedroc.systems.restaurant.service.domain.entity.Product;
import com.oriedroc.systems.restaurant.service.domain.entity.Restaurant;
import com.oriedroc.systems.restaurant.service.domain.valueobject.OrderApprovalId;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class RestaurantDataAccessMapper {

    public List<UUID> restaurantToRestaurantProducts(Restaurant restaurant) {
        return restaurant.getOrderDetail().getProducts().stream()
                .map(product -> product.getId().getValue())
                .collect(Collectors.toList());
    }

    public Restaurant restaurantEntityToRestaurant(List<RestaurantEntity> restaurantEntities) {
        RestaurantEntity restaurantEntity =
                restaurantEntities.stream().findFirst().orElseThrow(() ->
                        new RestaurantDataAccessException("No restaurants found!"));

        List<Product> restaurantProducts = restaurantEntities.stream().map(entity ->
                        Product.builder()
                                .productId(new ProductId(entity.getProductId()))
                                .name(entity.getProductName())
                                .price(new Money(entity.getProductPrice()))
                                .available(entity.getProductAvailable())
                                .build())
                .collect(Collectors.toList());

        return Restaurant.builder()
                .restaurantId(new RestaurantId(restaurantEntity.getRestaurantId()))
                .orderDetail(OrderDetail.builder()
                        .products(restaurantProducts)
                        .build())
                .active(restaurantEntity.getRestaurantActive())
                .build();
    }

    public OrderApprovalEntity orderApprovalToOrderApprovalEntity(OrderApproval orderApproval) {
        return OrderApprovalEntity.builder()
                .id(orderApproval.getId().getValue())
                .restaurantId(orderApproval.getRestaurantId().getValue())
                .orderId(orderApproval.getOrderId().getValue())
                .status(orderApproval.getApprovalStatus())
                .build();
    }

    public OrderApproval orderApprovalEntityToOrderApproval(OrderApprovalEntity orderApprovalEntity) {
        return OrderApproval.builder()
                .orderApprovalId(new OrderApprovalId(orderApprovalEntity.getId()))
                .restaurantId(new RestaurantId(orderApprovalEntity.getRestaurantId()))
                .orderId(new OrderId(orderApprovalEntity.getOrderId()))
                .approvalStatus(orderApprovalEntity.getStatus())
                .build();
    }

}
