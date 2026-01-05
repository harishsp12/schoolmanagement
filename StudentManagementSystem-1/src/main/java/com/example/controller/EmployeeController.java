package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.entity.EmployeeEntity;
import com.example.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repo;

    // ➤ CREATE (POST)
    @PostMapping("/add")
    public ResponseEntity<String> addEmployee(@RequestBody EmployeeEntity emp) {
        try {
            // duplicate email
            if (repo.findByEmail(emp.getEmail()).isPresent()) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("Email already exists");
            }

            // duplicate phone
            if (repo.findByPhone(emp.getPhone()).isPresent()) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("Phone already exists");
            }

            repo.save(emp);
            return ResponseEntity.ok("Employee added successfully");

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error while adding employee");
        }
    }

    // ➤ READ ALL (GET)
    @GetMapping("/all")
    public ResponseEntity<?> getAllEmployees() {
        try {
            List<EmployeeEntity> list = repo.findAll();
            return ResponseEntity.ok(list);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error fetching employees");
        }
    }

    // ➤ READ BY ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long id) {
        try {
            EmployeeEntity emp = repo.findById(id).orElse(null);

            if (emp == null) {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("Employee not found with ID: " + id);
            }

            return ResponseEntity.ok(emp);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error fetching employee");
        }
    }

    // ➤ UPDATE (PUT)
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateEmployee(
            @PathVariable Long id,
            @RequestBody EmployeeEntity data) {

        try {
            EmployeeEntity emp = repo.findById(id).orElse(null);

            if (emp == null) {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("Employee not found");
            }

            emp.setEmpName(data.getEmpName());
            emp.setEmail(data.getEmail());
            emp.setPassword(data.getPassword());
            emp.setDepartment(data.getDepartment());
            emp.setRole(data.getRole());
            emp.setPhone(data.getPhone());
            emp.setSalary(data.getSalary());
            emp.setAddress(data.getAddress());
            

            repo.save(emp);
            return ResponseEntity.ok("Employee updated successfully");

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error updating employee");
        }
    }

    // ➤ DELETE (DELETE)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        try {
            if (!repo.existsById(id)) {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("Employee not found");
            }

            repo.deleteById(id);
            return ResponseEntity.ok("Employee deleted successfully");

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error deleting employee");
        }
    }
}
