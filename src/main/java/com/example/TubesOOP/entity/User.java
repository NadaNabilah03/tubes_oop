package com.example.TubesOOP.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.Id;


@MappedSuperclass
public abstract class User {

    @NotBlank(message = "Username tidak boleh kosong")
    @Column(unique = true)
    protected String username;

    @NotBlank(message = "Email tidak boleh kosong")
    @Email(message = "Format email harus valid")
    @Column(unique = true)
    protected String email;

    @NotBlank(message = "Password tidak boleh kosong")
    protected String password;

    protected String profilePic;

    // Getters & Setters

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

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }
}
