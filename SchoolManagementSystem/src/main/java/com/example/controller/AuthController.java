//package com.example.controller;
//
//import org.springframework.web.bind.annotation.*;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import com.example.repository.*;
//import com.example.entity.*;
//
//@RestController
//@RequestMapping("/auth")
//@CrossOrigin
//public class AuthController {
//
//    private final StudentRepository studentRepo;
//    private final StaffRepository staffRepo;
//    private final BCryptPasswordEncoder encoder;
//
//    public AuthController(StudentRepository studentRepo,
//                          StaffRepository staffRepo,
//                          BCryptPasswordEncoder encoder) {
//        this.studentRepo = studentRepo;
//        this.staffRepo = staffRepo;
//        this.encoder = encoder;
//    }
//
//    @PostMapping("/login")
//    public String login(@RequestParam String email,
//                        @RequestParam String password) {
//
//        try {
//            var student = studentRepo.findByEmail(email);
//            if (student.isPresent() &&
//                encoder.matches(password, student.get().getPassword())) {
//                return "STUDENT LOGIN SUCCESS";
//            }
//
//            var staff = staffRepo.findByEmail(email);
//            if (staff.isPresent() &&
//                encoder.matches(password, staff.get().getPassword())) {
//                return "STAFF LOGIN SUCCESS";
//            }
//
//            return "Invalid credentials";
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "Login error";
//        }
//    }
//}
