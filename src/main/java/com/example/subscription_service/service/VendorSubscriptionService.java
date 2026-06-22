package com.example.subscription_service.service;

import com.example.subscription_service.dto.VendorPurchaseRequest;
import com.example.subscription_service.entity.SubscriptionPlan;
import com.example.subscription_service.entity.VendorSubscription;
import com.example.subscription_service.repository.SubscriptionPlanRepository;
import com.example.subscription_service.repository.VendorSubscriptionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class VendorSubscriptionService {

    @Autowired
    private VendorSubscriptionRepository repository;

    @Autowired
    private SubscriptionPlanRepository planRepository;

    public String purchasePlan(
            VendorPurchaseRequest request) {

        SubscriptionPlan plan =
                planRepository.findById(
                        request.getPlanId())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Plan Not Found"));

        LocalDate startDate =
                LocalDate.now();

        LocalDate expiryDate =
                startDate.plusDays(
                        plan.getDurationDays());

        VendorSubscription subscription =
                new VendorSubscription();

        subscription.setVendorId(
                request.getVendorId());

        subscription.setPlanId(
                plan.getId());

        subscription.setStartDate(
                startDate);

        subscription.setExpiryDate(
                expiryDate);

        subscription.setStatus(
                "ACTIVE");

        repository.save(subscription);

        return "Subscription Purchased Successfully";
    }
}