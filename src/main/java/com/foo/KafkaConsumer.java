package com.foo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.kafka.serializer.common.StringDecoder;

@Slf4j
@EnableBinding(KafkaInputChannel.class)
public class KafkaConsumer {

    @ServiceActivator(inputChannel=KafkaInputChannel.INPUT)
    public void loggerSink(byte[] payload) {
        StringDecoder springStringDecoder = new StringDecoder();
        String message = springStringDecoder.fromBytes(payload);
        log.error("*** KafkaConsumer payload message " + message);
    }
}
