package com.example.subscription_service.controller;

import com.example.subscription_service.dto.SubscriptionPlanRequest;
import com.example.subscription_service.entity.SubscriptionPlan;
import com.example.subscription_service.service.SubscriptionPlanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plans")
public class SubscriptionPlanController {

    private final SubscriptionPlanService service;

    public SubscriptionPlanController(
            SubscriptionPlanService service) {

        this.service = service;
    }

    @PostMapping("/create")
    public SubscriptionPlan createPlan(
            @RequestBody SubscriptionPlanRequest request) {

        return service.createPlan(request);
    }

    @GetMapping("/all")
    public List<SubscriptionPlan> getAllPlans() {

        return service.getAllPlans();
    }
}