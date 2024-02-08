package com.oriedroc.systems.payment.service.domain.ports.output.repository;

import com.oriedroc.systems.domain.valueobject.CustomerId;
import com.oriedroc.systems.payment.service.domain.entity.CreditEntry;

import java.util.Optional;

public interface CreditEntryRepository {
    CreditEntry save(CreditEntry creditEntry);

    Optional<CreditEntry> findByCustomerId(CustomerId customerId);
}
