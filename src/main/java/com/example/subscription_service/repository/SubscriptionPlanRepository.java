package com.example.subscription_service.repository;

import com.example.subscription_service.entity.SubscriptionPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionPlanRepository
        extends JpaRepository<SubscriptionPlan, Long> {
}