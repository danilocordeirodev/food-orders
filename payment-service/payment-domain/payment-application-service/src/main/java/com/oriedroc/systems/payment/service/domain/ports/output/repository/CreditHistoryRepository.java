package com.oriedroc.systems.payment.service.domain.ports.output.repository;

import com.oriedroc.systems.domain.valueobject.CustomerId;
import com.oriedroc.systems.payment.service.domain.entity.CreditHistory;

import java.util.List;
import java.util.Optional;

public interface CreditHistoryRepository {
    CreditHistory save(CreditHistory creditHistory);

    Optional<List<CreditHistory>> findByCustomerId(CustomerId customerId);
}
