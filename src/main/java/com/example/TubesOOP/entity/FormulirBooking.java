package com.example.TubesOOP.entity;

import com.example.TubesOOP.enums.BookingStatus;
import com.example.TubesOOP.enums.WasteType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "formulir_booking")
public class FormulirBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private WasteType jenisSampah;


    @DecimalMin(value = "0.1", message = "Berat sampah minimal 0.1 kg")
    private Double beratSampah;

    @DecimalMin(value = "100", message = "Harga minimal Rp100")
    private Double harga;

    @NotNull(message = "Tanggal pickup tidak boleh kosong")
    private LocalDate tanggalPickup;

    @NotNull(message = "Jam pickup tidak boleh kosong")
    private LocalTime jamPickup;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Status tidak boleh kosong")
    private BookingStatus status;

    // Relasi ke Customer (yang memesan)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;

    // Relasi ke Collector (yang mengambil sampah)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "collector_id")
    @JsonIgnore
    private Collector collector;

    // === Constructors ===

    public FormulirBooking() {
    }

    public FormulirBooking(WasteType jenisSampah, Double beratSampah, Double harga,
                           LocalDate tanggalPickup, LocalTime jamPickup,
                           BookingStatus status, Customer customer, Collector collector) {
        this.jenisSampah = jenisSampah;
        this.beratSampah = beratSampah;
        this.harga = harga;
        this.tanggalPickup = tanggalPickup;
        this.jamPickup = jamPickup;
        this.status = status;
        this.customer = customer;
        this.collector = collector;
    }

    // === Getters & Setters ===

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
