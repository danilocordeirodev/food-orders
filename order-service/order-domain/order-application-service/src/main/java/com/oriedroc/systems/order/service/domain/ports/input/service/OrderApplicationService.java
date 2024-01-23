package com.oriedroc.systems.order.service.domain.ports.input.service;

import com.oriedroc.systems.order.service.domain.dto.create.CreateOrderCommand;
import com.oriedroc.systems.order.service.domain.dto.create.CreateOrderResponse;
import com.oriedroc.systems.order.service.domain.dto.track.TrackOrderQuery;
import com.oriedroc.systems.order.service.domain.dto.track.TrackOrderResponse;
import jakarta.validation.Valid;

public interface OrderApplicationService {
    CreateOrderResponse createOrder(@Valid CreateOrderCommand createOrderCommand);
    TrackOrderResponse trackOrder(@Valid TrackOrderQuery trackOrderQuery);
}
