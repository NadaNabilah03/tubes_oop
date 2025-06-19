package com.example.TubesOOP.Controller;

import com.example.TubesOOP.entity.FormulirBooking;
import com.example.TubesOOP.enums.WasteType;
import com.example.TubesOOP.enums.BookingStatus;
import com.example.TubesOOP.payload.BookingRequest;
import com.example.TubesOOP.payload.BookingResponse;
import com.example.TubesOOP.payload.AssignBookingRequest;
import com.example.TubesOOP.service.FormulirBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Controller
@RequestMapping("/booking")

public class FormulirBookingController {

    @Autowired
    private FormulirBookingService bookingService;

    @PostMapping("/customer/create")
    public String createBooking(@ModelAttribute BookingRequest request) {
        try {
            bookingService.createBooking(
                    request.getJenisSampah(),
                    request.getBeratSampah(),
                    LocalDate.parse(request.getTanggalPickup()),
                    LocalTime.parse(request.getJamPickup()),
                    request.getCustomerId()
            );
            return "redirect:/customerHistory";
        } catch (Exception e) {
            return "redirect:/form?error";
        }
    }


    @GetMapping("/customer/{id}")
    public String getCustomerBookings(@PathVariable Long id, Model model) {
        try {
            List<BookingResponse> bookings = bookingService.getBookingsByCustomerId(id);
            model.addAttribute("bookingList", bookings);
            return "customerHistory";
        } catch (Exception e) {
            return "error";
        }
    }


    @GetMapping("/collector/{id}")
    public String getCollectorBookings(@PathVariable Long id, Model model) {
        try {
            List<BookingResponse> bookings = bookingService.getBookingsByCollectorId(id);
            model.addAttribute("bookings", bookings);
            return "collectorHistory";
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
    public String assignBooking(@ModelAttribute AssignBookingRequest request) {
        try {
            bookingService.assignCollector(request.getBookingId(), request.getCollectorId());
            return "redirect:/admin-dashboard";
        } catch (Exception e) {
            return "redirect:/admin-dashboard?error";
        }
    }

    @PostMapping("/cancel/customer/{id}")
    public String cancelBookingCustomer(@PathVariable Long id) {
        try {
            bookingService.cancelBooking(id);
            return "redirect:/customer/history";
        } catch (Exception e) {
            return "redirect:/customer/history?error";
        }
    }

    @PostMapping("/complete/collector/{id}")
    public String completeBookingCollector(@PathVariable Long id) {
        try {
            bookingService.completeBooking(id);
            return "redirect:/collector/history";
        } catch (Exception e) {
            return "redirect:/collector/history?error";
        }
    }

    @PostMapping("/cancel/collector/{id}")
    public String cancelBookingCollector(@PathVariable Long id) {
        try {
            bookingService.cancelBooking(id);
            return "redirect:/collector/history";
        } catch (Exception e) {
            return "redirect:/collector/history?error";
        }
    }


    @GetMapping("/form")
    public String showBookingForm() {
        return "form";
    }

}
