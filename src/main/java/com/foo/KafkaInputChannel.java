package com.foo;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface KafkaInputChannel {
    String INPUT = "kafkaInputChannel";

    @Input(KafkaInputChannel.INPUT)
    SubscribableChannel input();
}
