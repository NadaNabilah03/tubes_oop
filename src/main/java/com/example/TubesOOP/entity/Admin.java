package com.example.TubesOOP.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "admins")
public class Admin extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Long adminId;

    // Constructor default
    public Admin() {
        this.setProfilePic("/image/avatar.jpg");
    }

    // Constructor dengan parameter dasar
    public Admin(String username, String email, String password) {
        this.setUsername(username);
        this.setEmail(email);
        this.setPassword(password);
        this.setProfilePic("/image/avatar.jpg");
    }

    // Constructor lengkap
    public Admin(Long adminId, String username, String email, String password, String profilePic) {
        this.adminId = adminId;
        this.setUsername(username);
        this.setEmail(email);
        this.setPassword(password);
        this.setProfilePic(profilePic);
    }

    // Getter dan Setter khusus untuk adminId
    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }
}