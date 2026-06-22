package com.example.subscription_service.controller;

import com.example.subscription_service.service.KafkaProducerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaTestController {

    @Autowired
    private KafkaProducerService producer;

    @GetMapping("/kafka/test")
    public String testKafka() {

        producer.sendMessage(
                "Hello Kafka"
        );

        return "Message Sent Successfully";
    }
}