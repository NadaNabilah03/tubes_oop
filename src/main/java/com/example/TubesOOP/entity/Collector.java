package com.example.TubesOOP.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "collectors")
public class Collector extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "collector_id")
    private Long collectorId;

    @NotBlank(message = "Nomor HP tidak boleh kosong")
    private String phoneNumber;

    @NotBlank(message = "Alamat tidak boleh kosong")
    private String address;

    @NotNull
    private Boolean active = true;

    @OneToMany(mappedBy = "collector", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<HistoryBooking> historyHandled = new ArrayList<>();

    @OneToMany(mappedBy = "collector", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<FormulirBooking> formulirBookings = new ArrayList<>();

    public Long getCollectorId() {
        return collectorId;
    }

    public void setCollectorId(Long collectorId) {
        this.collectorId = collectorId;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Collector() {}

    public Collector(String username, String email, String password, String phoneNumber, String address) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.profilePic = "/image/avatar.jpg";
    }

    public Collector(String username, String email, String password, String phoneNumber, String address, String profilePic) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.profilePic = profilePic;
    }

    public Collector(
            Long id,
            String username,
            String email,
            String password,
            String profilePic,
            String phoneNumber,
            String address,
            Boolean active,
            List<HistoryBooking> historyHandled,
            List<FormulirBooking> formulirBookings
    ) {
        this.collectorId = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.profilePic = profilePic;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.active = active;
        this.historyHandled = historyHandled;
        this.formulirBookings = formulirBookings;
    }

}
