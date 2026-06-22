package com.example.subscription_service.controller;

import com.example.subscription_service.dto.*;
import com.example.subscription_service.entity.User;
import com.example.subscription_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;


    @PostMapping("/register")
    public User register(
            @RequestBody UserRegisterRequest request) {

        return service.register(
                request);
    }

    @GetMapping("/{userId}")
    public User getUserById(
            @PathVariable Long userId) {

        return service.getUserById(userId);
    }
    
    
    @PostMapping("/login")
    public UserLoginResponse login(
            @RequestBody UserLoginRequest request) {

        return service.login(
                request);
    }
}