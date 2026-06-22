package com.example.subscription_service.controller;

import com.example.subscription_service.dto.VendorEnquiryRequest;
import com.example.subscription_service.entity.VendorEnquiry;
import com.example.subscription_service.service.VendorEnquiryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vendor-enquiry")
public class VendorEnquiryController {

    @Autowired
    private VendorEnquiryService service;

    @PostMapping("/register")
    public VendorEnquiry registerVendor(
            @RequestBody VendorEnquiryRequest request) {

        return service.createEnquiry(request);
    }
    
    @GetMapping("/{vendorId}")
    public VendorEnquiry getVendorById(
            @PathVariable Long vendorId) {

        return service.getVendorById(vendorId);
    }
}