package com.example.TubesOOP.payload.admin;

import java.time.LocalDateTime;

public class AdminRegisterResponse {
    private Long adminId;
    private String username;
    private String email;
    private String profilePic;
    private String status;

    // Constructor
    public AdminRegisterResponse(Long adminId, String username, String email,
                                 String profilePic) {
        this.adminId = adminId;
        this.username = username;
        this.email = email;
        this.profilePic = profilePic;
        this.status = "Registrasi berhasil";
    }

    // Getters
    public Long getAdminId() {
        return adminId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public String getStatus() {
        return status;
    }
}