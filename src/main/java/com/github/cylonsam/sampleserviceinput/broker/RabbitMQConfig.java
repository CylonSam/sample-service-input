package com.github.cylonsam.sampleserviceinput.broker;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Bean("dataQueue")
    public Queue myQueue() {
        return new Queue("dataQueue", false);
    }
}
