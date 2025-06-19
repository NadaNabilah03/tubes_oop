package com.example.TubesOOP.payload.customer;

import jakarta.validation.constraints.NotBlank;

public class CustomerLoginRequest {
    @NotBlank(message = "Email tidak boleh kosong")
    private String email;

    @NotBlank(message = "Password tidak boleh kosong")
    private String password;

    // Getters & Setters
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}

