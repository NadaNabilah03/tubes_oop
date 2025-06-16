package com.example.TubesOOP.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class AdminLoginRequest {

    @NotBlank(message = "Email tidak boleh kosong")
    @Email(message = "Format email harus valid")
    private String email;

    @NotBlank(message = "Password tidak boleh kosong")
    private String password;

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
}
