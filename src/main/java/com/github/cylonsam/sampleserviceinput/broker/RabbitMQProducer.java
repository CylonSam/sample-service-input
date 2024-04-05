package com.github.cylonsam.sampleserviceinput.broker;

import com.github.cylonsam.sampleserviceinput.model.DataDto;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQProducer {
    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;

    @Autowired
    public RabbitMQProducer(RabbitTemplate rabbitTemplate, @Qualifier("dataQueue") Queue queue) {
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
    }

    public void sendMessage(final DataDto message) {
        rabbitTemplate.convertAndSend(queue.getName(), message);
    }
}
