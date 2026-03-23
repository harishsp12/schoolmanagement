package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.entity.RegisterForm;
import com.example.service.RegisterService;

@RestController
@RequestMapping("/register")
@CrossOrigin(origins="*")
public class RegisterController {

@Autowired
RegisterService service;

@PostMapping("/save")
public RegisterForm save(@RequestBody RegisterForm form){
return service.save(form);
}

@GetMapping("/all")
public List<RegisterForm> getAll(){

return service.getAll();

}

@GetMapping("/{id}")
public RegisterForm getById(@PathVariable Long id){

return service.getById(id);

}

@PutMapping("/update/{id}")
public RegisterForm update(@PathVariable Long id,@RequestBody RegisterForm form){

return service.update(id, form);

}

@DeleteMapping("/delete/{id}")
public String delete(@PathVariable Long id){

return service.delete(id);

}

}