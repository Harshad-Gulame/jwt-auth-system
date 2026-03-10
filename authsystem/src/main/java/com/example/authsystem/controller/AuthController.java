package com.example.authsystem.controller;

import com.example.authsystem.dto.AuthResponseDTO;
import com.example.authsystem.dto.LoginRequestDTO;
import com.example.authsystem.dto.RegisterRequestDTO;
import com.example.authsystem.service.AuthService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterRequestDTO request) {
        return authService.registerUser(request);
    }

    @PostMapping("/login")
    public AuthResponseDTO loginUser(@RequestBody LoginRequestDTO request) {
        return authService.loginUser(request);
    }
}