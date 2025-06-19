package com.example.TubesOOP.payload.admin;

public class AdminInfoResponse {
    private Long adminId;
    private String username;
    private String email;

    public AdminInfoResponse(Long adminId, String username, String email) {
        this.adminId = adminId;
        this.username = username;
        this.email = email;
    }

    // Getters & Setters
    public Long getId() { return adminId; }
    public void setId(Long id) { this.adminId = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
