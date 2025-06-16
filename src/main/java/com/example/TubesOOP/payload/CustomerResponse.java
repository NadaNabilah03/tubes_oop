package com.example.TubesOOP.payload;

public class CustomerResponse {
    private Long id;
    private String nama;
    private String email;
    private String alamat;
    private String noTelepon;

    // Constructor
    public CustomerResponse(Long id, String nama, String email, String alamat, String noTelepon) {
        this.id = id;
        this.nama = nama;
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

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
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

