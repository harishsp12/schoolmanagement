package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entity.RegisterForm;

public interface RegisterRepository extends JpaRepository<RegisterForm, Long>{

boolean existsByMobileNo(String mobileNo);

boolean existsByAadharNo(String aadharNo);

}