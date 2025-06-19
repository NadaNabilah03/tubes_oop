package com.example.TubesOOP.payload;

import com.example.TubesOOP.enums.WasteType;

public class BookingRequest {
    private WasteType jenisSampah;
    private Double beratSampah;
    private String tanggalPickup;
    private String jamPickup;
    private Long customerId;

    // Getter & Setter
    public WasteType getJenisSampah() {
        return jenisSampah;
    }

    public void setJenisSampah(WasteType jenisSampah) {
        this.jenisSampah = jenisSampah;
    }

    public Double getBeratSampah() {
        return beratSampah;
    }

    public void setBeratSampah(Double beratSampah) {
        this.beratSampah = beratSampah;
    }

    public String getTanggalPickup() {
        return tanggalPickup;
    }

    public void setTanggalPickup(String tanggalPickup) {
        this.tanggalPickup = tanggalPickup;
    }

    public String getJamPickup() {
        return jamPickup;
    }

    public void setJamPickup(String jamPickup) {
        this.jamPickup = jamPickup;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
