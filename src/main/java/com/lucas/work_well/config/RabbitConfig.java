package com.lucas.work_well.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String QUEUE_NAME = "workwell_queue";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME, false);
    }
}
