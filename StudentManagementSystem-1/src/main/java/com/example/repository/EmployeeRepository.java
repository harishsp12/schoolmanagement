package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    // 🔐 LOGIN
    Optional<EmployeeEntity> findByEmailAndPassword(String email, String password);

    // 🔍 Duplicate checks
    Optional<EmployeeEntity> findByEmail(String email);
    Optional<EmployeeEntity> findByPhone(String phone);
}
