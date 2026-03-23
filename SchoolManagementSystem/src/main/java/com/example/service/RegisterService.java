package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.RegisterForm;
import com.example.repository.RegisterRepository;

@Service
public class RegisterService {

@Autowired
RegisterRepository repo;

public RegisterForm save(RegisterForm form){

if(repo.existsByMobileNo(form.getMobileNo())){
throw new RuntimeException("Mobile Number Already Exists");
}

if(repo.existsByAadharNo(form.getAadharNo())){
throw new RuntimeException("Aadhar Number Already Exists");
}

return repo.save(form);

}

public List<RegisterForm> getAll(){
return repo.findAll();
}

public RegisterForm getById(Long id){
return repo.findById(id).orElse(null);
}

public RegisterForm update(Long id, RegisterForm form){

RegisterForm existing = repo.findById(id).orElse(null);

if(existing != null){

existing.setChildName(form.getChildName());
existing.setFatherName(form.getFatherName());
existing.setMotherName(form.getMotherName());
existing.setMobileNo(form.getMobileNo());
existing.setDob(form.getDob());
existing.setAge(form.getAge());
existing.setAadharNo(form.getAadharNo());
existing.setAddress(form.getAddress());

return repo.save(existing);

}

return null;

}

public String delete(Long id){

repo.deleteById(id);

return "Record Deleted Successfully";

}

}