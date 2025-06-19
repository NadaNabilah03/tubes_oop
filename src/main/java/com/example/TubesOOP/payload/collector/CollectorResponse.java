package com.example.TubesOOP.payload.collector;

public class CollectorResponse {
    private Long id;
    private String username;
    private String email;
    private String address;
    private String phoneNumber;
    private boolean aktif;

    public CollectorResponse(Long id, String username, String email, String alamat, String noTelepon, boolean aktif) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.address = alamat;
        this.phoneNumber = noTelepon;
        this.aktif = aktif;
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
    public void setUsername(String nama) {
        this.username = nama;
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

    public boolean isAktif() {
        return aktif;
    }
    public void setAktif(boolean aktif) {
        this.aktif = aktif;
    }
}
