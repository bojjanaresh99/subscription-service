package com.example.subscription_service.controller;

import com.example.subscription_service.dto.VendorPurchaseRequest;
import com.example.subscription_service.service.VendorSubscriptionService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subscription")
public class VendorSubscriptionController {

    @Autowired
    private VendorSubscriptionService service;

    @PostMapping("/purchase")
    public String purchasePlan(
            @RequestBody VendorPurchaseRequest request) {

        return service.purchasePlan(request);
    }
}