package com.example.TubesOOP.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "collectors")
public class Collector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nama tidak boleh kosong")
    private String name;

    @NotBlank(message = "Email tidak boleh kosong")
    @Email(message = "Format email harus valid")
    private String email;

    @NotBlank(message = "Password tidak boleh kosong")
    private String password;

    @NotBlank(message = "Nomor HP tidak boleh kosong")
    private String phoneNumber;

    @NotBlank(message = "Alamat tidak boleh kosong")
    private String address;

    private String profilePic;

    @NotNull
    private Boolean active = true;

    // Riwayat pengambilan sampah yang pernah collector ini lakukan
    @OneToMany(mappedBy = "collector", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<HistoryBooking> historyHandled = new ArrayList<>();

    @OneToMany(mappedBy = "collector", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<FormulirBooking> formulirBookings = new ArrayList<>();

    public Collector() {
    }

    public Collector(String name, String email, String password, String phoneNumber, String address, String profilePic) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.profilePic = profilePic;
        this.active = true;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public List<HistoryBooking> getHistoryHandled() {
        return historyHandled;
    }

    public void setHistoryHandled(List<HistoryBooking> historyHandled) {
        this.historyHandled = historyHandled;
    }

    public List<FormulirBooking> getFormulirBookings() {
        return formulirBookings;
    }

    public void setFormulirBookings(List<FormulirBooking> formulirBookings) {
        this.formulirBookings = formulirBookings;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
