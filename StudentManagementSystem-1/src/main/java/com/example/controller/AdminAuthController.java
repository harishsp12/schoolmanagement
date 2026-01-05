package com.example.controller;

import org.springframework.web.bind.annotation.*;

import com.example.dto.LoginRequest;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminAuthController {

    // 🔐 ADMIN LOGIN
    @PostMapping("/admin/login")
    public String adminLogin(@RequestBody LoginRequest req) {
        try {
            String adminEmail = "admin@gmail.com";
            String adminPassword = "admin123";

            if (adminEmail.equals(req.getEmail()) &&
                adminPassword.equals(req.getPassword())) {

                return "Admin login successful";
            } else {
                return "Invalid admin email or password";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Admin login error";
        }
    }
}
