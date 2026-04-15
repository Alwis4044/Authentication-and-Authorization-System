package com.alwis.identity.auth.service;

import com.alwis.identity.auth.dto.AuthResponse;
import com.alwis.identity.auth.dto.LoginRequest;
import com.alwis.identity.auth.dto.RegisterRequest;

public interface AuthService {

    String register(RegisterRequest request);

    AuthResponse login(LoginRequest request);

    AuthResponse refresh(String refreshToken);
}
