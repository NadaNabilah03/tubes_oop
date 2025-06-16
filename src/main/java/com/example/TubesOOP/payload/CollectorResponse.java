package com.example.TubesOOP.payload;

public class CollectorResponse {
    private Long id;
    private String nama;
    private String email;
    private String alamat;
    private String noTelepon;
    private boolean aktif;

    public CollectorResponse(Long id, String nama, String email, String alamat, String noTelepon, boolean aktif) {
        this.id = id;
        this.nama = nama;
        this.email = email;
        this.alamat = alamat;
        this.noTelepon = noTelepon;
        this.aktif = aktif;
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

    public boolean isAktif() {
        return aktif;
    }
    public void setAktif(boolean aktif) {
        this.aktif = aktif;
    }
}
