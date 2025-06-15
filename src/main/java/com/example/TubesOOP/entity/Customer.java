package com.example.TubesOOP.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username tidak boleh kosong")
    private String username;

    @NotBlank(message = "Email tidak boleh kosong")
    @Email(message = "Format email harus valid")
    private String email;

    @NotBlank(message = "Password tidak boleh kosong")
    private String password;

    @NotBlank(message = "Nomor HP tidak boleh kosong")
    @Pattern(regexp = "^\\+?\\d{10,15}$", message = "Nomor HP harus valid dan terdiri dari 10-15 digit, bisa diawali +")
    private String phoneNumber;

    @NotBlank(message = "Alamat tidak boleh kosong")
    private String address;

    private String profilePic;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<HistoryBooking> historyBookings = new ArrayList<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<FormulirBooking> formulirBookings = new ArrayList<>();

    public Customer() {
    }

    //constructor untuk ambil data dari db
    public Customer(Long id, String username, String email, String password, String phoneNumber,
                    String address, String profilePic, List<HistoryBooking> historyBookings,
                    List<FormulirBooking> formulirBookings) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.profilePic = profilePic;
        this.historyBookings = historyBookings;
        this.formulirBookings = formulirBookings;
    }

    // constructor untuk user baru tanpa upload pp
    public Customer(String username, String email, String password, String phoneNumber, String address) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.profilePic = "/images/defaultPP.jpg";
        this.historyBookings = new ArrayList<>();
        this.formulirBookings = new ArrayList<>();
    }

    //constructor untuk user baru upload pp
    public Customer(String username, String email, String password, String phoneNumber, String address, String profilePic) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.profilePic = profilePic;
        this.historyBookings = new ArrayList<>();
        this.formulirBookings = new ArrayList<>();
    }

    // Getter & Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
