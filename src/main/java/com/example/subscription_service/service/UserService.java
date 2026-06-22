package com.example.subscription_service.service;

import com.example.subscription_service.dto.*;
import com.example.subscription_service.entity.User;
import com.example.subscription_service.repository.UserRepository;
import com.example.subscription_service.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;


    // Registration
    public User register(
            UserRegisterRequest request) {

        User user = new User();

        user.setFullName(
                request.getFullName());

        user.setEmail(
                request.getEmail());

        user.setMobileNumber(
                request.getMobileNumber());

        user.setPassword(
                passwordEncoder.encode(
                        request.getPassword()));

        return repository.save(user);
    }
    public User getUserById(
            Long userId) {

        return repository.findById(userId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "User Not Found"));
    }

    // Login
    public UserLoginResponse login(
            UserLoginRequest request) {

        User user =
                repository.findByEmail(
                        request.getEmail())
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "User Not Found"));

        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword())) {

            throw new RuntimeException(
                    "Invalid Password");
        }

        String token =
                jwtUtil.generateToken(
                        user.getUserId(),
                        user.getEmail());

        UserLoginResponse response =
                new UserLoginResponse();

        response.setToken(
                token);

        response.setMessage(
                "Login Successful");

        return response;
    }
}