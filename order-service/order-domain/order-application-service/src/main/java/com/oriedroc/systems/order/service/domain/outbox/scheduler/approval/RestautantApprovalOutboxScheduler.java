package com.oriedroc.systems.order.service.domain.outbox.scheduler.approval;

import com.oriedroc.systems.order.service.domain.outbox.model.approval.OrderApprovalOutboxMessage;
import com.oriedroc.systems.order.service.domain.outbox.model.payment.OrderPaymentOutboxMessage;
import com.oriedroc.systems.order.service.domain.outbox.scheduler.payment.PaymentOutboxHelper;
import com.oriedroc.systems.order.service.domain.ports.output.message.publisher.payment.PaymentRequestMessagePublisher;
import com.oriedroc.systems.order.service.domain.ports.output.message.publisher.restaurantapproval.RestaurantApprovalRequestMessagePublisher;
import com.oriedroc.systems.outbox.OutboxScheduler;
import com.oriedroc.systems.outbox.OutboxStatus;
import com.oriedroc.systems.saga.SagaStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Component
public class RestautantApprovalOutboxScheduler implements OutboxScheduler {

    private final ApprovalOutboxHelper approvalOutboxHelper;
    private final RestaurantApprovalRequestMessagePublisher restaurantApprovalRequestMessagePublisher;

    public RestautantApprovalOutboxScheduler(ApprovalOutboxHelper
                                                     approvalOutboxHelper,
                                             RestaurantApprovalRequestMessagePublisher
                                                     restaurantApprovalRequestMessagePublisher) {
        this.approvalOutboxHelper = approvalOutboxHelper;
        this.restaurantApprovalRequestMessagePublisher = restaurantApprovalRequestMessagePublisher;
    }

    @Override
    @Transactional
    @Scheduled(fixedDelayString = "${order-service.outbox-scheduler-fixed-rate}",
                initialDelayString = "${order-service.outbox-scheduler-initial-delay}")
    public void processOutboxMessage() {
        Optional<List<OrderApprovalOutboxMessage>> outboxMessagesResponse =
                approvalOutboxHelper.getApprovalOutboxMessageByOutboxStatusAndSagaStatus(
                        OutboxStatus.STARTED,
                        SagaStatus.PROCESSING
                );
        if(outboxMessagesResponse.isPresent() && !outboxMessagesResponse.get().isEmpty()) {
            List<OrderApprovalOutboxMessage> outboxMessages = outboxMessagesResponse.get();
            log.info("Received {} OrderApprovalOutboxMessage with id: {}, sending to message bus!",
                    outboxMessages.size(),
                    outboxMessages.stream().map(outboxMessage ->
                            outboxMessage.getId().toString()).collect(Collectors.joining(",")));
            outboxMessages.forEach(outboxMessage ->
                    restaurantApprovalRequestMessagePublisher.publish(outboxMessage, this::updateOutboxStatus));
            log.info("{} OrderApprovalOutboxMessage sent to bus!", outboxMessages.size());
        }
    }

    private void updateOutboxStatus(OrderApprovalOutboxMessage orderPaymentOutboxMessage, OutboxStatus outboxStatus) {
        orderPaymentOutboxMessage.setOutboxStatus(outboxStatus);
        approvalOutboxHelper.save(orderPaymentOutboxMessage);
        log.info("OrderApprovalOutboxMessage is updated with outbox status: {}", outboxStatus.name());
    }
}
