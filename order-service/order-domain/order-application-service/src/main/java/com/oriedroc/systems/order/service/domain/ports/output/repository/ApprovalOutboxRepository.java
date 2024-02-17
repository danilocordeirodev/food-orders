package com.oriedroc.systems.order.service.domain.ports.output.repository;

import com.oriedroc.systems.order.service.domain.outbox.model.approval.OrderApprovalOutboxMessage;
import com.oriedroc.systems.order.service.domain.outbox.model.payment.OrderPaymentOutboxMessage;
import com.oriedroc.systems.outbox.OutboxStatus;
import com.oriedroc.systems.saga.SagaStatus;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ApprovalOutboxRepository {
    OrderApprovalOutboxMessage save(OrderApprovalOutboxMessage orderApprovalOutboxMessage);
    Optional<List<OrderApprovalOutboxMessage>> findByTypeAndOutboxStatusAndSagaStatus(String type,
                                                                                     OutboxStatus outboxStatus,
                                                                                     SagaStatus... sagaStatus);
    Optional<OrderApprovalOutboxMessage> findByTypeAndSagaIdAndSagaStatus(String type,
                                                                         UUID sagaId,
                                                                         SagaStatus... sagaStatus);
    void deleteByTypeAndOutboxStatusAndSagaStatus(String type,
                                                  OutboxStatus outboxStatus,
                                                  SagaStatus... sagaStatus);
}
