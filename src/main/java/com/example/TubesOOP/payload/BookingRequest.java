package com.example.TubesOOP.payload;

import com.example.TubesOOP.enums.WasteType;

public class BookingRequest {
    private String jenisSampah;      // akan di-convert manual ke WasteType
    private String beratSampah;      // convert manual ke Double
    private String tanggalPickup;    // convert ke LocalDate
    private String jamPickup;        // convert ke LocalTime
    private Long customerId;       // convert ke Long

    // getter-setter


    public String getJenisSampah() {
        return jenisSampah;
    }

    public void setJenisSampah(String jenisSampah) {
        this.jenisSampah = jenisSampah;
    }

    public String getBeratSampah() {
        return beratSampah;
    }

    public void setBeratSampah(String beratSampah) {
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

