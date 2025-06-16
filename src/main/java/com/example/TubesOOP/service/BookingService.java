package com.example.TubesOOP.service;

import com.example.TubesOOP.entity.FormulirBooking;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    // Method untuk hitung harga otomatis berdasarkan berat
    public void hitungHarga(FormulirBooking booking) {
        Double berat = booking.getBeratSampah();
        if (berat == null || berat <= 0) {
            throw new IllegalArgumentException("Berat sampah harus lebih dari 0");
        }

        double harga;
        if (berat <= 5) {
            harga = 10000.0;
        } else {
            harga = berat * 1000.0;
        }

        booking.setHarga(harga);
    }

    // Contoh method simpan booking (misal nanti pake repository)
    public FormulirBooking simpanBooking(FormulirBooking booking) {

        hitungHarga(booking);
        return booking;
    }
}
