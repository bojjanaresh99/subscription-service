package com.example.subscription_service.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

//    @KafkaListener(
//            topics = "vendor-subscription-topic",
//            groupId = "subscription-group"
//    )
    public void consume(String message) {

        System.out.println(
                "=================================="
        );

        System.out.println(
                "KAFKA MESSAGE RECEIVED"
        );

        System.out.println(
                message
        );

        System.out.println(
                "=================================="
        );
    }
}