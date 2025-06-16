package com.example.TubesOOP.Controller;

import com.example.TubesOOP.enums.WasteType;
import com.example.TubesOOP.service.FormulirBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.TubesOOP.enums.BookingStatus;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDate;
import java.time.LocalTime;

@RestController
@RequestMapping("/api/booking")
public class FormulirBookingController {

    @Autowired
    private FormulirBookingService bookingService;

    // Tambah Booking Baru (oleh Customer)
    @PostMapping("/create")
    public ResponseEntity<?> createBooking(
            @RequestParam WasteType jenisSampah,
            @RequestParam Double beratSampah,
            @RequestParam String tanggalPickup,
            @RequestParam String jamPickup,
            @RequestParam Long customerId
    ) {
        try {
            bookingService.createBooking(
                    jenisSampah,
                    beratSampah,
                    LocalDate.parse(tanggalPickup),
                    LocalTime.parse(jamPickup),
                    customerId
            );
            return ResponseEntity.ok("Booking berhasil dibuat.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Lihat semua booking (admin)
    @GetMapping("/all")
    public ResponseEntity<?> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    // Lihat booking berdasarkan customer
    @GetMapping("/customer/{id}")
    public ResponseEntity<?> getCustomerBookings(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(bookingService.getBookingsByCustomerId(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Lihat booking berdasarkan collector (riwayat collector)
    @GetMapping("/collector/{id}")
    public ResponseEntity<?> getCollectorBookings(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(bookingService.getBookingsByCollectorId(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Lihat booking berdasarkan status (untuk admin)
    @GetMapping("/status/{status}")
    public ResponseEntity<?> getBookingsByStatus(@PathVariable BookingStatus status) {
        try {
            return ResponseEntity.ok(bookingService.getBookingsByStatus(status));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Assign Collector ke Booking
    @PostMapping("/assign")
    public ResponseEntity<?> assignBooking(
            @RequestParam Long bookingId,
            @RequestParam Long collectorId
    ) {
        try {
            bookingService.assignCollector(bookingId, collectorId);
            return ResponseEntity.ok("Booking berhasil di-assign.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Tandai booking sebagai selesai
    @PostMapping("/complete/{id}")
    public ResponseEntity<?> completeBooking(@PathVariable Long id) {
        try {
            bookingService.completeBooking(id);
            return ResponseEntity.ok("Booking selesai.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Cancel booking
    @PostMapping("/cancel/{id}")
    public ResponseEntity<?> cancelBooking(@PathVariable Long id) {
        try {
            bookingService.cancelBooking(id);
            return ResponseEntity.ok("Booking dibatalkan.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
