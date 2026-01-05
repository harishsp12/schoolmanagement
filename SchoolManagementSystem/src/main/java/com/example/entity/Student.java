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
@Table(name = "student")
@Data
public class Student {

	 @Id
	    @GeneratedValue(generator = "student-id-gen")
	    @GenericGenerator(
	        name = "student-id-gen",
	        strategy = "com.example.generator.StudentIdGenerator"
    )
    private Long id;

    @Column(nullable = false)
    private String studentName;

    private LocalDate dob;
    private String gender;

    @Column(name = "student_class")
    private String studentClass;

    @Column(nullable = false)
    private String password;

    @Column(unique = true)
    private String email;

    @Column(unique = true, length = 10)
    private String phoneNo;

    private String address;

    @Column(unique = true, length = 12)
    private String aadharNo;

    private String fatherName;
    private String motherName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
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
	public String getStudentClass() {
		return studentClass;
	}
	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
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
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getMotherName() { 
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public Student(String studentName, LocalDate dob, String gender, String studentClass, String password, String email,
			String phoneNo, String address, String aadharNo, String fatherName, String motherName) {
		super();
		this.studentName = studentName;
		this.dob = dob;
		this.gender = gender;
		this.studentClass = studentClass;
		this.password = password;
		this.email = email;
		this.phoneNo = phoneNo;
		this.address = address;
		this.aadharNo = aadharNo;
		this.fatherName = fatherName;
		this.motherName = motherName;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
