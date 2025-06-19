package com.example.TubesOOP.payload.collector;

public class CollectorRegisterResponse {
    private Long collectorId;
    private String username;
    private String email;
    private String phoneNumber;
    private String address;
    private Boolean active;

    // Constructor
    public CollectorRegisterResponse(Long collectorId, String username, String email,
                                     String phoneNumber, String address, Boolean active) {
        this.collectorId = collectorId;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.active = active;
    }

    // Getters
    public Long getCollectorId() {
        return collectorId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public Boolean getActive() {
        return active;
    }
}