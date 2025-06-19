package com.example.TubesOOP.payload.customer;

public class CustomerLogoutResponse {

    private String message;

    public CustomerLogoutResponse(String message) {
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
