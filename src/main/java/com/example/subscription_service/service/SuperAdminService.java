package com.example.subscription_service.service;

import com.example.subscription_service.dto.SuperAdminRequest;
import com.example.subscription_service.entity.SuperAdmin;
import com.example.subscription_service.repository.SuperAdminRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SuperAdminService {

    private final SuperAdminRepository repository;
    private final PasswordEncoder passwordEncoder;

    public SuperAdminService(
            SuperAdminRepository repository,
            PasswordEncoder passwordEncoder) {

        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public String register(SuperAdminRequest request) {

        SuperAdmin admin = new SuperAdmin();

        admin.setFullName(request.getFullName());
        admin.setEmail(request.getEmail());
        admin.setPassword(
                passwordEncoder.encode(request.getPassword()));

        repository.save(admin);

        return "Super Admin Registered Successfully";
    }
}