package com.example.TubesOOP.payload;

public class CustomerResponse {
    private Long id;
    private String username;
    private String email;
    private String alamat;
    private String noTelepon;

    // Constructor
    public CustomerResponse(Long id, String nama, String email, String alamat, String noTelepon) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.alamat = alamat;
        this.noTelepon = noTelepon;
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

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }
}

