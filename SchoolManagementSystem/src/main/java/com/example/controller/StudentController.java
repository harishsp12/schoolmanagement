package com.example.controller;

import com.example.entity.Student;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService service;

    // ===== CREATE =====
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Student s) {
        try {
            Student saved = service.save(s);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Save failed");
        }
    }

    // ===== GET ALL =====
    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        try {
            List<Student> list = service.getAll();
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Fetch failed");
        }
    }

    // ===== GET BY ID =====
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            Student s = service.getById(id);
            if (s == null) return ResponseEntity.notFound().build();
            return ResponseEntity.ok(s);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Fetch by id failed");
        }
    }

    // ===== UPDATE =====
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Student s) {
        try {
            Student updated = service.update(id, s);
            if (updated == null) {
                return ResponseEntity.notFound().build();   // ✅ FIX
            }
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build(); // ✅ FIX
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            boolean ok = service.delete(id);
            if (!ok) {
                return ResponseEntity.notFound().build();   // ✅ FIX
            }
            return ResponseEntity.ok("Deleted");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build(); // ✅ FIX
        }
    }


    // ===== LOGIN =====
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Student s) {
        Student db = service.login(s.getId(), s.getPassword());
        if (db == null) {
            return ResponseEntity.status(401)
                    .body("INVALID STUDENT ID OR PASSWORD");
        }
        return ResponseEntity.ok(db);
    }
}
