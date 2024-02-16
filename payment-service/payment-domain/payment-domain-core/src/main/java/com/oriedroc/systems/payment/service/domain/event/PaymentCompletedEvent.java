package com.oriedroc.systems.payment.service.domain.event;

import com.oriedroc.systems.domain.event.publisher.DomainEventPublisher;
import com.oriedroc.systems.payment.service.domain.entity.Payment;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PaymentCompletedEvent extends PaymentEvent{

    public PaymentCompletedEvent(Payment payment,
                                 ZonedDateTime createdAt) {
        super(payment, createdAt, Collections.emptyList());
    }

}
