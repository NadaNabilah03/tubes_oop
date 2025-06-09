package com.example.TubesOOP.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CollectorUpdateRequest {

    @NotBlank(message = "Nama tidak boleh kosong")
    private String nama;

    @NotBlank(message = "Email tidak boleh kosong")
    @Email(message = "Email tidak valid")
    private String email;

    @NotBlank(message = "Alamat tidak boleh kosong")
    private String alamat;

    @NotBlank(message = "No. Telepon tidak boleh kosong")
    @Size(min = 10, max = 15, message = "No. Telepon harus antara 10-15 karakter")
    private String noTelepon;

    @NotBlank(message = "Area tugas tidak boleh kosong")
    private String areaTugas;

    private boolean aktif;

    // Getter & Setter
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
    public String getAreaTugas() {
        return areaTugas;
    }
    public void setAreaTugas(String areaTugas) {
        this.areaTugas = areaTugas;
    }
    public boolean isAktif() {
        return aktif;
    }
    public void setAktif(boolean aktif) {
        this.aktif = aktif;
    }
}
