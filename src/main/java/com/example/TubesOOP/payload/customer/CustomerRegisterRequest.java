package com.example.TubesOOP.payload.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CustomerRegisterRequest {

    @NotBlank(message = "Username tidak boleh kosong")
    private String username;

    @NotBlank(message = "Email tidak boleh kosong")
    @Email(message = "Format email tidak valid")
    private String email;

    @NotBlank(message = "Password tidak boleh kosong")
    @Size(min = 6, message = "Password minimal 6 karakter")
    private String password;

    @NotBlank(message = "Alamat tidak boleh kosong")
    private String address;

    @NotBlank(message = "No. Telepon tidak boleh kosong")
    private String phoneNumber;


    // Getter & Setter
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public @NotBlank(message = "Alamat tidak boleh kosong") String getAddress() {
        return address;
    }

    public void setAddress(@NotBlank(message = "Alamat tidak boleh kosong") String alamat) {
        this.address = alamat;
    }

    public @NotBlank(message = "No. Telepon tidak boleh kosong") String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@NotBlank(message = "No. Telepon tidak boleh kosong") String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
