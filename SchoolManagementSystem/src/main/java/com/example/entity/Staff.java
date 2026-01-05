package com.example.entity;

import java.time.LocalDate;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "staff")
@Data
public class Staff {

	@Id
    @GeneratedValue(generator = "staff-id-gen")
    @GenericGenerator(
        name = "staff-id-gen",
        strategy = "com.example.generator.StaffIdGenerator"
    )
    private Long id;

    @Column(nullable = false)
    private String staffName;

    private LocalDate dob;
    private String gender;

    @Column(name = "staff_class")
    private String staffClass;

    @Column(nullable = false)
    private String password;

    @Column(unique = true)
    private String email;

    @Column(unique = true, length = 10)
    private String phoneNo;

    private String address;

    @Column(unique = true, length = 12)
    private String aadharNo;
    
    @Column(nullable = false)
    private Double salary;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStaffClass() {
		return staffClass;
	}

	public void setStaffClass(String staffClass) {
		this.staffClass = staffClass;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Staff(String staffName, LocalDate dob, String gender, String staffClass, String password, String email,
			String phoneNo, String address, String aadharNo, Double salary) {
		super();
		this.staffName = staffName;
		this.dob = dob;
		this.gender = gender;
		this.staffClass = staffClass;
		this.password = password;
		this.email = email;
		this.phoneNo = phoneNo;
		this.address = address;
		this.aadharNo = aadharNo;
		this.salary = salary;
	}

	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

}