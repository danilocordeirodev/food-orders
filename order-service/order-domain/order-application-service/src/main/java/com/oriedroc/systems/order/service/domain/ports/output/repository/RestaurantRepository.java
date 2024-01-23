package com.oriedroc.systems.order.service.domain.ports.output.repository;

import com.oriedroc.systems.order.service.domain.entity.Restaurant;

import java.util.Optional;

public interface RestaurantRepository {
    Optional<Restaurant> findRestaurantInformation(Restaurant restaurant);
}
