package com.github.cylonsam.sampleserviceinput.controller;

import com.github.cylonsam.sampleserviceinput.broker.RabbitMQProducer;
import com.github.cylonsam.sampleserviceinput.model.DataDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InputController {
    private final RabbitMQProducer rabbitMQProducer;

    public InputController(final RabbitMQProducer rabbitMQProducer) {
        this.rabbitMQProducer = rabbitMQProducer;
    }

    @PostMapping("/api/data")
    public void postData(@RequestBody DataDto dataDto){
        rabbitMQProducer.sendMessage(dataDto);
    }
}
