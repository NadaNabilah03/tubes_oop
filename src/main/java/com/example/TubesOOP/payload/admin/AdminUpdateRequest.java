package com.example.TubesOOP.payload.admin;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class AdminUpdateRequest {

    @NotBlank(message = "Nama tidak boleh kosong")
    private String username;

    @NotBlank(message = "Email tidak boleh kosong")
    @Email(message = "Email tidak valid")
    private String email;

    // Getter & Setter
    public String getUsername() {
        return username;
    }
    public void setUsername(String nama) {
        this.username = nama;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
