package com.example.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;

    private String empName;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    private String department;
    private String role;

    @Column(unique = true)
    private String phone;

    private Double salary;

    
    private String address;

    
   
    private LocalDate dateOfBirth;



	public Long getEmpId() {
		return empId;
	}



	public void setEmpId(Long empId) {
		this.empId = empId;
	}



	public String getEmpName() {
		return empName;
	}



	public void setEmpName(String empName) {
		this.empName = empName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getDepartment() {
		return department;
	}



	public void setDepartment(String department) {
		this.department = department;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public Double getSalary() {
		return salary;
	}



	public void setSalary(Double salary) {
		this.salary = salary;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}



	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



	public EmployeeEntity(String empName, String email, String password, String department, String role, String phone,
			Double salary, String address, LocalDate dateOfBirth) {
		super();
		this.empName = empName;
		this.email = email;
		this.password = password;
		this.department = department;
		this.role = role;
		this.phone = phone;
		this.salary = salary;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
	}



	public EmployeeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    
    
}