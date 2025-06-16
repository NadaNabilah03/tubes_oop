package com.example.TubesOOP.Controller;

import com.example.TubesOOP.enums.WasteType;
import com.example.TubesOOP.enums.BookingStatus;
import com.example.TubesOOP.service.FormulirBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;

@RestController
@RequestMapping("/api/booking")
public class FormulirBookingController {

    @Autowired
    private FormulirBookingService bookingService;

    @PostMapping("/create")
    public String createBooking(
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
            return "redirect:/history";
        } catch (Exception e) {
            return "redirect:/form?error";
        }
    }

    @GetMapping("/all")
    public String getAllBookings() {
        try {
            bookingService.getAllBookings();
            return "redirect:/admin-dashboard";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    @GetMapping("/customer/{id}")
    public String getCustomerBookings(@PathVariable Long id) {
        try {
            bookingService.getBookingsByCustomerId(id);
            return "redirect:/history";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    @GetMapping("/collector/{id}")
    public String getCollectorBookings(@PathVariable Long id) {
        try {
            bookingService.getBookingsByCollectorId(id);
            return "redirect:/history";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    @GetMapping("/status/{status}")
    public String getBookingsByStatus(@PathVariable BookingStatus status) {
        try {
            bookingService.getBookingsByStatus(status);
            return "redirect:/admin-dashboard";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    @PostMapping("/assign")
    public String assignBooking(
            @RequestParam Long bookingId,
            @RequestParam Long collectorId
    ) {
        try {
            bookingService.assignCollector(bookingId, collectorId);
            return "redirect:/admin-dashboard";
        } catch (Exception e) {
            return "redirect:/admin-dashboard?error";
        }
    }

    @PostMapping("/complete/{id}")
    public String completeBooking(@PathVariable Long id) {
        try {
            bookingService.completeBooking(id);
            return "redirect:/history";
        } catch (Exception e) {
            return "redirect:/history?error";
        }
    }

    @PostMapping("/cancel/{id}")
    public String cancelBooking(@PathVariable Long id) {
        try {
            bookingService.cancelBooking(id);
            return "redirect:/history";
        } catch (Exception e) {
            return "redirect:/history?error";
        }
    }
}
