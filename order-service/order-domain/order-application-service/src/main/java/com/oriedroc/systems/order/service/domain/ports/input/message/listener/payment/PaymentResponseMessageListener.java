package com.oriedroc.systems.order.service.domain.ports.input.message.listener.payment;

import com.oriedroc.systems.order.service.domain.dto.message.PaymentResponse;

public interface PaymentResponseMessageListener {
    void paymentCompleted(PaymentResponse paymentResponse);
    void paymentCancelled(PaymentResponse paymentResponse);
}
