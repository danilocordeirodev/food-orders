package com.oriedroc.systems.order.service.domain;

import com.oriedroc.systems.order.service.domain.dto.create.CreateOrderCommand;
import com.oriedroc.systems.order.service.domain.dto.create.CreateOrderResponse;
import com.oriedroc.systems.order.service.domain.dto.track.TrackOrderQuery;
import com.oriedroc.systems.order.service.domain.dto.track.TrackOrderResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderTrackCommandHandler {
    public TrackOrderResponse trackOrder(TrackOrderQuery trackOrderQuery) {

    }
}
