package com.example.TubesOOP.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;

    @NotBlank(message = "Nomor HP tidak boleh kosong")
    @Pattern(regexp = "^\\+?\\d{10,15}$", message = "Nomor HP harus valid dan terdiri dari 10-15 digit, bisa diawali +")
    private String phoneNumber;

    @NotBlank(message = "Alamat tidak boleh kosong")
    private String address;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<HistoryBooking> historyBookings = new ArrayList<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<FormulirBooking> formulirBookings = new ArrayList<>();

    public Customer() {
    }

    // Constructor ambil data dari DB
    public Customer(Long id, String username, String email, String password, String phoneNumber,
                    String address, String profilePic,
                    List<HistoryBooking> historyBookings, List<FormulirBooking> formulirBookings) {
        this.customerId = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.profilePic = profilePic;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.historyBookings = historyBookings;
        this.formulirBookings = formulirBookings;
    }

    // Constructor untuk user baru TANPA upload profilePic
    public Customer(String username, String email, String password, String phoneNumber, String address) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.profilePic = "/image/avatar.jpg";
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    // Constructor untuk user baru DENGAN upload profilePic
    public Customer(String username, String email, String password, String phoneNumber, String address, String profilePic) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.profilePic = profilePic;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    // Getters & Setters

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<HistoryBooking> getHistoryBookings() {
        return historyBookings;
    }

    public void setHistoryBookings(List<HistoryBooking> historyBookings) {
        this.historyBookings = historyBookings;
    }

    public List<FormulirBooking> getFormulirBookings() {
        return formulirBookings;
    }

    public void setFormulirBookings(List<FormulirBooking> formulirBookings) {
        this.formulirBookings = formulirBookings;
    }
}
