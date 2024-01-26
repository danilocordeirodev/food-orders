package com.oriedroc.systems.order.service.messaging.publisher.kafka;

import com.oriedroc.systems.kafka.order.avro.model.PaymentRequestAvroModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

@Slf4j
@Component
public class OrderKafkaMessageHelper {
    public <T> CompletableFuture<SendResult<String, T>>
    getKafkaCallback(String responseTopicName, T requestAvroModel, String orderId, String requestAvroModelName) {
        return new CompletableFuture<SendResult<String, T>>() {
            @Override
            public CompletableFuture<SendResult<String, T>> whenComplete(BiConsumer<? super SendResult<String, T>, ? super Throwable> action) {
                return super.whenComplete((result, ex )-> {
                    if (ex!= null) {
                        log.error("Error while sending " + requestAvroModelName +
                                "message {} to topic {}", requestAvroModel.toString(), responseTopicName, ex);
                    } else {
                        RecordMetadata metadata = result.getRecordMetadata();
                        log.info("Received successfull response from kafka for order id: {}" +
                                        " Topic: {} Partition: {} Offset: {} Timestamp: {}",
                                orderId,
                                metadata.topic(),
                                metadata.partition(),
                                metadata.offset(),
                                metadata.timestamp());
                    }
                });
            }
        };
    }
}
