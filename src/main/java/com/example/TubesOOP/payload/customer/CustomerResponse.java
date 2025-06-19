package com.example.TubesOOP.payload.customer;

public class CustomerResponse {
    private Long id;
    private String username;
    private String email;
    private String address;
    private String phoneNumber;

    // Constructor
    public CustomerResponse(Long id, String username, String email, String alamat, String noTelepon) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.address = alamat;
        this.phoneNumber = noTelepon;
    }

    // Getter & Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

