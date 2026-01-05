package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.dto.LoginRequest;
import com.example.dto.LoginResponse;
import com.example.entity.StudentEntity;
import com.example.entity.EmployeeEntity;
import com.example.repository.StudentRepository;
import com.example.repository.EmployeeRepository;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {
 
    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private EmployeeRepository employeeRepo;

    // ✅ SINGLE LOGIN API (ADMIN / STUDENT / EMPLOYEE)
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest req) {

        try {
            // 1️⃣ ADMIN LOGIN
            if ("admin@gmail.com".equals(req.getEmail()) &&
                "admin123".equals(req.getPassword())) {

                return new LoginResponse("ADMIN", null);
            }

            // 2️⃣ STUDENT LOGIN
            StudentEntity student =
                studentRepo.findByEmailAndPassword(
                    req.getEmail(), req.getPassword()
                ).orElse(null);

            if (student != null) {
                return new LoginResponse("STUDENT", student.getStudentId());
            }

            // 3️⃣ EMPLOYEE LOGIN
            EmployeeEntity emp =
                employeeRepo.findByEmailAndPassword(
                    req.getEmail(), req.getPassword()
                ).orElse(null);

            if (emp != null) {
                return new LoginResponse("EMPLOYEE", emp.getEmpId());
            }

            // ❌ INVALID LOGIN
            return new LoginResponse("INVALID", null);

        } catch (Exception e) {
            e.printStackTrace();
            return new LoginResponse("ERROR", null);
        }
    }
}
