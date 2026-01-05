package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.entity.Staff;
import com.example.service.StaffService;

@RestController
@RequestMapping("/staff")
@CrossOrigin
public class StaffController {

    @Autowired
    private StaffService service;

    @PostMapping("/save")
    public String save(@RequestBody Staff s) {
        return service.saveStaff(s);
    }

    @GetMapping("/all")
    public List<Staff> all() {
        return service.getAllStaff();
    }

    @GetMapping("/{id}")
    public Staff get(@PathVariable Long id) {
        return service.getStaffById(id);
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable Long id,
                         @RequestBody Staff s) {
        return service.updateStaff(id, s);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return service.deleteStaff(id);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Staff s) {
        Staff db = service.login(s.getId(), s.getPassword());
        if (db == null) {
            return ResponseEntity.status(401).body("Login failed");
        }
        return ResponseEntity.ok(db);
    }
}
