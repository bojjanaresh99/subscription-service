package com.example.subscription_service.controller;

import com.example.subscription_service.dto.LoginRequest;
import com.example.subscription_service.dto.LoginResponse;
import com.example.subscription_service.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("/vendor-login")
    public LoginResponse login(
            @RequestBody LoginRequest request) {

        return service.login(request);
    }
}