package com.example.TubesOOP.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "admins")
public class Admin extends User {

    public Admin() {}

    public Admin(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.profilePic = "/image/avatar.jpg"; // default
    }

    public Admin(String username, String email, String password, String profilePic) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.profilePic = profilePic;
    }

    public Admin(Long id, String username, String email, String password, String profilePic) {
        this.setId(id);
        this.username = username;
        this.email = email;
        this.password = password;
        this.profilePic = profilePic;
    }
}
