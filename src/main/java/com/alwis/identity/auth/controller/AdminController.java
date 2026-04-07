package com.alwis.identity.auth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AdminController {

    @GetMapping("/admin/profile")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminDashboard(){
        return "Admin Dashboard Accessed";
    }

}
