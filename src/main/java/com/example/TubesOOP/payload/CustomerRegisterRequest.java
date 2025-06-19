package com.example.TubesOOP.payload;

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

    @NotBlank(message = "Nama tidak boleh kosong")
    private String nama;

    @NotBlank(message = "Alamat tidak boleh kosong")
    private String alamat;

    @NotBlank(message = "No. Telepon tidak boleh kosong")
    private String noTelepon;


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

    public @NotBlank(message = "Nama tidak boleh kosong") String getNama() {
        return nama;
    }

    public void setNama(@NotBlank(message = "Nama tidak boleh kosong") String nama) {
        this.nama = nama;
    }

    public @NotBlank(message = "Alamat tidak boleh kosong") String getAlamat() {
        return alamat;
    }

    public void setAlamat(@NotBlank(message = "Alamat tidak boleh kosong") String alamat) {
        this.alamat = alamat;
    }

    public @NotBlank(message = "No. Telepon tidak boleh kosong") String getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(@NotBlank(message = "No. Telepon tidak boleh kosong") String noTelepon) {
        this.noTelepon = noTelepon;
    }
}
