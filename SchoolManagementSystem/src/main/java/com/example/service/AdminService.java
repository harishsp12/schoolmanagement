package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Admin;
import com.example.repository.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin login(String email, String password) {

        Admin admin = adminRepository.findByEmail(email).orElse(null);

        if (admin == null) {
            return null;
        }

        if (!admin.getPassword().equals(password)) {
            return null;
        }

        return admin;
    }
}