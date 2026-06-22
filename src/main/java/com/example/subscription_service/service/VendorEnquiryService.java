package com.example.subscription_service.service;

import com.example.subscription_service.dto.VendorEnquiryRequest;
import com.example.subscription_service.entity.VendorEnquiry;
import com.example.subscription_service.repository.VendorEnquiryRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

@Service
public class VendorEnquiryService {

    @Autowired
    private VendorEnquiryRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public VendorEnquiry createEnquiry(
            VendorEnquiryRequest request) {

        VendorEnquiry enquiry =
                new VendorEnquiry();

        enquiry.setVendorName(
                request.getVendorName());

        enquiry.setMobileNumber(
                request.getMobileNumber());

        enquiry.setEmail(
                request.getEmail());

        enquiry.setBusinessName(
                request.getBusinessName());

        enquiry.setCity(
                request.getCity());

        enquiry.setStatus(
                "ENQUIRY_CREATED");

        enquiry.setPassword(

                passwordEncoder.encode(

                        request.getPassword()
                )
        );

        return repository.save(enquiry);
    }
    
    public VendorEnquiry getVendorById(
            Long vendorId) {

        return repository.findById(vendorId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Vendor Not Found"));
    }
}