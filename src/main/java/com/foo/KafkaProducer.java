package com.foo;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
@EnableBinding(KafkaOutputChannel.class)
public class KafkaProducer {

    @Bean
    @InboundChannelAdapter(value = KafkaOutputChannel.NAME, poller = @Poller(fixedDelay = "${producer.fixedDelayMilliseconds}", maxMessagesPerPoll = "${producer.maxMessagesPerPoll}"))
    public MessageSource<String> timerMessageSource() {
        return () -> new GenericMessage<>("kmh payload" + new SimpleDateFormat("M/d/y H:m:s").format(new Date()));
    }

}
