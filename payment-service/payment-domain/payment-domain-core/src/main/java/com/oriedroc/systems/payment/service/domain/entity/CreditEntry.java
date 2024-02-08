package com.oriedroc.systems.payment.service.domain.entity;

import com.oriedroc.systems.domain.entity.AggregateRoot;
import com.oriedroc.systems.domain.valueobject.CustomerId;
import com.oriedroc.systems.domain.valueobject.Money;
import com.oriedroc.systems.payment.service.domain.valueobject.CreditEntryId;

public class CreditEntry extends AggregateRoot<CreditEntryId> {
    private final CustomerId customerId;
    private Money totalCreditAmount;

    public void addCreditAmount(Money amount) {
        totalCreditAmount = totalCreditAmount.add(amount);
    }

    public void subtractCreditAmount(Money amount) {
        totalCreditAmount = totalCreditAmount.subtract(amount);
    }                                                     private CreditEntry(Builder builder) {
        setId(builder.creditEntryId);
        customerId = builder.customerId;
        setTotalCreditAmount(builder.totalCreditAmount);
    }

    public static Builder builder() {
        return new Builder();
    }

    public CustomerId getCustomerId() {
        return customerId;
    }

    public Money getTotalCreditAmount() {
        return totalCreditAmount;
    }

    public void setTotalCreditAmount(Money totalCreditAmount) {
        this.totalCreditAmount = totalCreditAmount;
    }


    public static final class Builder {
        private CreditEntryId creditEntryId;
        private CustomerId customerId;
        private Money totalCreditAmount;

        private Builder() {
        }

        public Builder id(CreditEntryId val) {
            creditEntryId = val;
            return this;
        }

        public Builder customerId(CustomerId val) {
            customerId = val;
            return this;
        }

        public Builder totalCreditAmount(Money val) {
            totalCreditAmount = val;
            return this;
        }

        public CreditEntry build() {
            return new CreditEntry(this);
        }
    }
}
