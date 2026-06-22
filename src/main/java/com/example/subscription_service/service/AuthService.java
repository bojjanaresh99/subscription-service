package com.example.subscription_service.service;

import com.example.subscription_service.dto.LoginRequest;
import com.example.subscription_service.dto.LoginResponse;
import com.example.subscription_service.entity.VendorEnquiry;
import com.example.subscription_service.repository.VendorEnquiryRepository;
import com.example.subscription_service.security.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private VendorEnquiryRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public LoginResponse login(
            LoginRequest request) {

        VendorEnquiry vendor =
                repository.findByEmail(
                        request.getEmail()
                ).orElseThrow(() ->
                        new RuntimeException(
                                "Vendor Not Found"
                        ));

        // Password Validation
        if (!passwordEncoder.matches(
                request.getPassword(),
                vendor.getPassword())) {

            throw new RuntimeException(
                    "Invalid Password"
            );
        }

        // Generate JWT Token
        String token =
                jwtUtil.generateToken(
                        vendor.getVendorId(), // Vendor Id
                        vendor.getEmail()     // Email
                );

        LoginResponse response =
                new LoginResponse();

        response.setToken(token);

        response.setMessage(
                "Login Successful"
        );

        return response;
    }
}