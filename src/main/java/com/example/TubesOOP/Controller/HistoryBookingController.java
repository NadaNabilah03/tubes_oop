package com.example.TubesOOP.Controller;

import com.example.TubesOOP.service.FormulirBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/history")
public class HistoryBookingController {

    @Autowired
    private FormulirBookingService bookingService;

    // Ambil riwayat booking berdasarkan ID customer
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<?> getCustomerHistory(@PathVariable Long customerId) {
        try {
            return ResponseEntity.ok(bookingService.getBookingsByCustomerId(customerId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    // Ambil riwayat booking berdasarkan ID collector
    @GetMapping("/collector/{collectorId}")
    public ResponseEntity<?> getCollectorHistory(@PathVariable Long collectorId) {
        try {
            return ResponseEntity.ok(bookingService.getBookingsByCollectorId(collectorId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}
