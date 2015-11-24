package com.foo;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Represents an outbound Kafka topic
 * By default, NAME will be used as the topic name unless overridden using application.properties.
 * Example: spring.cloud.stream.bindings.kafkaOutputChannel=myTopicName
 * Further reading: http://cloud.spring.io/spring-cloud-stream/spring-cloud-stream.html
 */
public interface KafkaOutputChannel {

    String NAME = "kafkaOutputChannel";

    @Output(KafkaOutputChannel.NAME)
    MessageChannel output();
}
