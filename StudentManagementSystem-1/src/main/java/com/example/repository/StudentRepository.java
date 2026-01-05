package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.StudentEntity;   // 🔥 THIS LINE WAS MISSING

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    Optional<StudentEntity> findByEmailAndPassword(String email, String password);

    Optional<StudentEntity> findByEmail(String email);

    Optional<StudentEntity> findByPhone(String phone);
}
