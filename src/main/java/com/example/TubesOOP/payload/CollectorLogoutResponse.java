package com.example.TubesOOP.payload;

public class CollectorLogoutResponse {

    private String message;

    public CollectorLogoutResponse(String message) {
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
