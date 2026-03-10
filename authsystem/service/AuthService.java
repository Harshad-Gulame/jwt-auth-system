package com.example.authsystem.service;

import com.example.authsystem.dto.LoginRequestDTO;
import com.example.authsystem.dto.RegisterRequestDTO;
import com.example.authsystem.dto.AuthResponseDTO;
import com.example.authsystem.entity.User;
import com.example.authsystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public String registerUser(RegisterRequestDTO request) {

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());

        userRepository.save(user);

        return "User registered successfully";
    }

    public AuthResponseDTO loginUser(LoginRequestDTO request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        // JWT token will be generated later
        String token = "dummy-jwt-token";

        return new AuthResponseDTO(token);
    }
}