package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {

    // email already exist check
    boolean existsByEmail(String email);

    // phone already exist check
    boolean existsByPhoneNo(String phoneNo);

    // aadhar already exist check
    boolean existsByAadharNo(String aadharNo);

    // login / find by email
    Optional<Staff> findByEmail(String email);

    // find staff by phone
    Optional<Staff> findByPhoneNo(String phoneNo);
}
