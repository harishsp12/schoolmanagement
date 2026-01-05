package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.entity.StudentEntity;
import com.example.repository.StudentRepository;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {

    @Autowired
    private StudentRepository repo;

    // ➤ CREATE (POST)
    @PostMapping("/addstudent")
    public ResponseEntity<String> addStudent(@RequestBody StudentEntity student) {
        try {
            if (repo.findByEmail(student.getEmail()).isPresent()) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("Email already exists");
            }

            if (repo.findByPhone(student.getPhone()).isPresent()) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("Phone number already exists");
            }

            repo.save(student);
            return ResponseEntity.ok("Student added successfully");

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error while adding student");
        }
    }

    // ➤ READ ALL (GET)
    @GetMapping("/all")
    public ResponseEntity<?> getAllStudents() {
        try {
            List<StudentEntity> list = repo.findAll();
            return ResponseEntity.ok(list);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error fetching students");
        }
    }

    // ➤ READ BY ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Long id) {
        try {
            StudentEntity student = repo.findById(id).orElse(null);

            if (student == null) {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("Student not found with ID: " + id);
            }

            return ResponseEntity.ok(student);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error fetching student");
        }
    }

    // ➤ UPDATE (PUT)
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateStudent(
            @PathVariable Long id,
            @RequestBody StudentEntity data) {

        try {
            StudentEntity student = repo.findById(id).orElse(null);

            if (student == null) {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("Student not found");
            }

            // ✅ CORRECT FIELD NAMES
            student.setStudentName(data.getStudentName());
            student.setEmail(data.getEmail());
            student.setPassword(data.getPassword());
            student.setDepartment(data.getDepartment());
            student.setYear(data.getYear());
            student.setPhone(data.getPhone());
            student.setAddress(data.getAddress());
            student.setFatherName(data.getFatherName());
            student.setMotherName(data.getMotherName());

            repo.save(student);
            return ResponseEntity.ok("Student updated successfully");

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error updating student");
        }
    }

    // ➤ DELETE (DELETE)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        try {
            if (!repo.existsById(id)) {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("Student not found");
            }

            repo.deleteById(id);
            return ResponseEntity.ok("Student deleted successfully");

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error deleting student");
        }
    }
}
