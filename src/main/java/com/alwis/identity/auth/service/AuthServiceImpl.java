package com.alwis.identity.auth.service;

import com.alwis.identity.auth.dto.AuthResponse;
import com.alwis.identity.auth.dto.LoginRequest;
import com.alwis.identity.auth.dto.RegisterRequest;
import com.alwis.identity.auth.entity.Role;
import com.alwis.identity.auth.entity.User;
import com.alwis.identity.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public String register(RegisterRequest request) {

        if(userRepository.existsByUsername(request.getUsername())){
            throw new RuntimeException("Username already exists");
        }

        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(user);

        return "User registered successfully";
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if(!passwordEncoder.matches(request.getPassword(),user.getPassword())){
            throw new RuntimeException("Invalid credentials");
        }

        // JWT will be added in next step
        return new AuthResponse("Login successful (token coming next)");
    }
}
