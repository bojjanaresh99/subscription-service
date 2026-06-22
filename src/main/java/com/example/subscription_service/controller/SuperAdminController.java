package com.example.subscription_service.controller;

import com.example.subscription_service.dto.SuperAdminRequest;
import com.example.subscription_service.service.SuperAdminService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/super-admin")
public class SuperAdminController {

    private final SuperAdminService service;

    public SuperAdminController(
            SuperAdminService service) {

        this.service = service;
    }

    @PostMapping("/register")
    public String register(
            @RequestBody SuperAdminRequest request) {

        return service.register(request);
    }
}