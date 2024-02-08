package com.oriedroc.systems.payment.service.domain;

import com.oriedroc.systems.payment.service.domain.entity.CreditEntry;
import com.oriedroc.systems.payment.service.domain.entity.CreditHistory;
import com.oriedroc.systems.payment.service.domain.entity.Payment;
import com.oriedroc.systems.payment.service.domain.event.PaymentEvent;

import java.util.List;

public interface PaymentDomainService {
    PaymentEvent validateAndInitiatePayment(Payment payment,
                                            CreditEntry creditEntry,
                                            List<CreditHistory> creditHistories,
                                            List<String> failureMessages);

    PaymentEvent validateAndCancelPayment(Payment payment,
                                            CreditEntry creditEntry,
                                            List<CreditHistory> creditHistories,
                                            List<String> failureMessages);
}
