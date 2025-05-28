package com.example.TubesOOP.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "history_booking")
public class HistoryBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Tanggal booking tidak boleh kosong")
    private LocalDateTime tanggalBooking;

    @NotNull(message = "Jenis sampah tidak boleh kosong")
    private String jenisSampah;

    @NotNull(message = "Berat sampah tidak boleh kosong")
    private Double beratSampah;

    @NotNull(message = "Harga tidak boleh kosong")
    private Double harga;

    @NotNull(message = "Status booking tidak boleh kosong")
    private String status; // contoh: "Selesai", "Dibatalkan", dsb

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "collector_id")
    private Collector collector;

    public HistoryBooking() {
    }

    public HistoryBooking(LocalDateTime tanggalBooking, String jenisSampah,
                          Double beratSampah, Double harga, String status, Customer customer) {
        this.tanggalBooking = tanggalBooking;
        this.jenisSampah = jenisSampah;
        this.beratSampah = beratSampah;
        this.harga = harga;
        this.status = status;
        this.customer = customer;
    }

    // Getter & Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTanggalBooking() {
        return tanggalBooking;
    }

    public void setTanggalBooking(LocalDateTime tanggalBooking) {
        this.tanggalBooking = tanggalBooking;
    }

    public String getJenisSampah() {
        return jenisSampah;
    }

    public void setJenisSampah(String jenisSampah) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Collector getCollector() {
        return collector;
    }

    public void setCollector(Collector collector) {
        this.collector = collector;
    }

}
