package com.example.subscription_service.repository;

import com.example.subscription_service.entity.VendorSubscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorSubscriptionRepository
        extends JpaRepository<VendorSubscription, Long> {
}