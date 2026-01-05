package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Staff;
import com.example.repository.StaffRepository;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    /* =========================
       STAFF LOGIN (ID + PASSWORD)
       ========================= */
    public Staff login(Long id, String password) {

        Staff staff = staffRepository.findById(id).orElse(null);

        if (staff == null) {
            return null;
        }

        if (!staff.getPassword().equals(password)) {
            return null;
        }

        return staff;
    }

    /* =========================
       CREATE STAFF
       ========================= */
    public String saveStaff(Staff staff) {

        if (staffRepository.existsByEmail(staff.getEmail())) {
            return "EMAIL ALREADY EXISTS";
        }

        if (staffRepository.existsByPhoneNo(staff.getPhoneNo())) {
            return "PHONE NUMBER ALREADY EXISTS";
        }

        if (staffRepository.existsByAadharNo(staff.getAadharNo())) {
            return "AADHAR NUMBER ALREADY EXISTS";
        }

        staffRepository.save(staff);
        return "STAFF CREATED SUCCESSFULLY";
    }

    /* =========================
       GET ALL STAFF
       ========================= */
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    /* =========================
       GET STAFF BY ID
       (Option-2 style: return null)
       ========================= */
    public Staff getStaffById(Long id) {
        return staffRepository.findById(id).orElse(null);
    }

    /* =========================
       UPDATE STAFF
       ========================= */
    public String updateStaff(Long id, Staff staff) {

        Staff dbStaff = staffRepository.findById(id).orElse(null);

        if (dbStaff == null) {
            return "STAFF NOT FOUND";
        }

        staff.setId(id);
        staffRepository.save(staff);
        return "STAFF UPDATED SUCCESSFULLY";
    }

    /* =========================
       DELETE STAFF
       ========================= */
    public String deleteStaff(Long id) {

        if (!staffRepository.existsById(id)) {
            return "STAFF NOT FOUND";
        }

        staffRepository.deleteById(id);
        return "STAFF DELETED SUCCESSFULLY";
    }
}
