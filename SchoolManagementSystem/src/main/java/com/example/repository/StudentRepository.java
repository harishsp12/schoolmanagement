package com.example.repository;

import com.example.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    // ⭐ IMPORTANT FIX
    @Query("SELECT s FROM Student s ORDER BY LOWER(s.studentName) ASC, s.id ASC")
    List<Student> findAllSorted();

}