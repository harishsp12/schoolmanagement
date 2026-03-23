package com.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name="register_form")
public class RegisterForm {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(name="child_name")
private String childName;

@Column(name="father_name")
private String fatherName;

@Column(name="mother_name")
private String motherName;

@Column(name="mobile_no", unique = true)
private String mobileNo;

private String dob;

private Double age;

@Column(name="aadhar_no", unique = true)
private String aadharNo;

private String address;

public RegisterForm(){}

public Long getId() {
return id;
}

public void setId(Long id) {
this.id = id;
}

public String getChildName() {
return childName;
}

public void setChildName(String childName) {
this.childName = childName;
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

public String getMobileNo() {
return mobileNo;
}

public void setMobileNo(String mobileNo) {
this.mobileNo = mobileNo;
}

public String getDob() {
return dob;
}

public void setDob(String dob) {
this.dob = dob;
}

public Double getAge() {
return age;
}

public void setAge(Double age) {
this.age = age;
}

public String getAadharNo() {
return aadharNo;
}

public void setAadharNo(String aadharNo) {
this.aadharNo = aadharNo;
}

public String getAddress() {
return address;
}

public void setAddress(String address) {
this.address = address;
}

}