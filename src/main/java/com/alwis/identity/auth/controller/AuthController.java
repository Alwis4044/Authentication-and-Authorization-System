package com.alwis.identity.auth.controller;

import com.alwis.identity.auth.dto.AuthResponse;
import com.alwis.identity.auth.dto.LoginRequest;
import com.alwis.identity.auth.dto.RegisterRequest;
import com.alwis.identity.auth.entity.User;
import com.alwis.identity.auth.security.JwtService;
import com.alwis.identity.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/refresh")
    public ResponseEntity<AuthResponse> refresh(@RequestBody String refreshToken){
        return ResponseEntity.ok(authService.refresh(refreshToken));
    }

    @GetMapping("/test")
    public String test(){
        return "Protected API working";
    }
}
