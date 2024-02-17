package com.oriedroc.systems.order.service.messaging.listener.kafka;

import com.oriedroc.systems.kafka.consumer.KafkaConsumer;
import com.oriedroc.systems.kafka.order.avro.model.CustomerAvroModel;
import com.oriedroc.systems.kafka.order.avro.model.PaymentStatus;
import com.oriedroc.systems.order.service.domain.exception.OrderNotFoundException;
import com.oriedroc.systems.order.service.domain.ports.input.message.listener.customer.CustomerMessageListener;
import com.oriedroc.systems.order.service.messaging.mapper.OrderMessagingDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class CustomerKafkaListener implements KafkaConsumer<CustomerAvroModel> {
    private final CustomerMessageListener customerMessageListener;
    private final OrderMessagingDataMapper orderMessagingDataMapper;

    public CustomerKafkaListener(CustomerMessageListener customerMessageListener, OrderMessagingDataMapper orderMessagingDataMapper) {
        this.customerMessageListener = customerMessageListener;
        this.orderMessagingDataMapper = orderMessagingDataMapper;
    }


    @Override
    @KafkaListener(id = "${kafka-consumer-config.customer-group-id}", topics = "${order-service.customer-topic-name}")
    public void receive(@Payload List<CustomerAvroModel> messages,
                        @Header(KafkaHeaders.RECEIVED_KEY) List<String> keys,
                        @Header(KafkaHeaders.RECEIVED_PARTITION) List<Integer> partitions,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        log.info("{} number of customer messages receives with keys: {}, partitions: {} and offsets: {}",
                messages.size(),
                keys.toString(),
                partitions.toString(),
                offsets.toString());

        messages.forEach(customerAvroModel -> {
            customerMessageListener.customerCreated(orderMessagingDataMapper
                    .customerAvroModelToCustomerModel(customerAvroModel));
        });
    }
}
