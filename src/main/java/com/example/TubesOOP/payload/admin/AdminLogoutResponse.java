package com.example.TubesOOP.payload.admin;

public class AdminLogoutResponse {

    private String message;

    public AdminLogoutResponse(String message) {
        this.message = message;
    }

    // Getter & Setter
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
