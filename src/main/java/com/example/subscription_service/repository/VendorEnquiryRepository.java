package com.example.subscription_service.repository;

import com.example.subscription_service.entity.VendorEnquiry;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VendorEnquiryRepository
        extends JpaRepository<VendorEnquiry, Long> {

    Optional<VendorEnquiry> findByEmail(
            String email);
}