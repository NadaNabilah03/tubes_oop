package com.example.TubesOOP.payload;

import com.example.TubesOOP.enums.BookingStatus;
import com.example.TubesOOP.enums.WasteType;

import java.time.LocalDate;
import java.time.LocalTime;

public class BookingResponse {

    private Long id;
    private WasteType jenisSampah;
    private Double beratSampah;
    private Double harga;
    private LocalDate tanggalPickup;
    private LocalTime jamPickup;
    private BookingStatus status;

    private String customerUsername;
    private String collectorName;

    // Constructors
    public BookingResponse() {
    }

    public BookingResponse(Long id, WasteType jenisSampah, Double beratSampah, Double harga,
                           LocalDate tanggalPickup, LocalTime jamPickup, BookingStatus status,
                           String customerUsername, String collectorName) {
        this.id = id;
        this.jenisSampah = jenisSampah;
        this.beratSampah = beratSampah;
        this.harga = harga;
        this.tanggalPickup = tanggalPickup;
        this.jamPickup = jamPickup;
        this.status = status;
        this.customerUsername = customerUsername;
        this.collectorName = collectorName;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Double getHarga() {
        return harga;
    }

    public void setHarga(Double harga) {
        this.harga = harga;
    }

    public LocalDate getTanggalPickup() {
        return tanggalPickup;
    }

    public void setTanggalPickup(LocalDate tanggalPickup) {
        this.tanggalPickup = tanggalPickup;
    }

    public LocalTime getJamPickup() {
        return jamPickup;
    }

    public void setJamPickup(LocalTime jamPickup) {
        this.jamPickup = jamPickup;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public String getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }

    public String getCollectorName() {
        return collectorName;
    }

    public void setCollectorName(String collectorName) {
        this.collectorName = collectorName;
    }
}
