package com.example.dto;

public class LoginResponse {

    private String role;
    private Long id;

    public LoginResponse(String role, Long id) {
        this.role = role;
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public Long getId() {
        return id;
    }
}
