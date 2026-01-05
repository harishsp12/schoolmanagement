package com.example.service;

import com.example.entity.Student;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    // ===== CREATE =====
    public Student save(Student s) {
        return repo.save(s);
    }

    // ===== GET ALL =====
    public List<Student> getAll() {
        return repo.findAll();
    }

    // ===== GET BY ID =====
    public Student getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    // ===== UPDATE =====
    public Student update(Long id, Student s) {
        if (!repo.existsById(id)) return null;
        s.setId(id);                 // IMPORTANT
        return repo.save(s);
    }

    // ===== DELETE =====
    public boolean delete(Long id) {
        if (!repo.existsById(id)) return false;
        repo.deleteById(id);
        return true;
    }

    // ===== LOGIN (PASSWORD FORMAT HANDLED) =====
    public Student login(Long id, String inputPassword) {

        Student student = repo.findById(id).orElse(null);
        if (student == null) return null;

        String dbPassword = student.getPassword();

        // If DB stored as yyyy-mm-dd → convert to dd-mm-yyyy
        if (dbPassword != null && dbPassword.matches("\\d{4}-\\d{2}-\\d{2}")) {
            String[] p = dbPassword.split("-");
            dbPassword = p[2] + "-" + p[1] + "-" + p[0];
        }

        if (!dbPassword.equals(inputPassword)) return null;

        return student;
    }
}
