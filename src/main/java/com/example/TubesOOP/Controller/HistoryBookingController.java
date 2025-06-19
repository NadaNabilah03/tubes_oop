package com.example.TubesOOP.Controller;

import com.example.TubesOOP.service.FormulirBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/history")
public class HistoryBookingController {

    @Autowired
    private FormulirBookingService bookingService;

    // Customer melihat history-nya
    @GetMapping("/customer/{customerId}")
    public String getCustomerHistory(@PathVariable Long customerId, Model model) {
        try {
            model.addAttribute("bookings", bookingService.getBookingsByCustomerId(customerId));
            return "customerHistory";
        } catch (Exception e) {
            model.addAttribute("error", "Gagal mengambil data riwayat.");
            return "customerHistory";
        }
    }

    // Collector melihat history-nya
    @GetMapping("/collector/{collectorId}")
    public String getCollectorHistory(@PathVariable Long collectorId, Model model) {
        try {
            model.addAttribute("bookings", bookingService.getBookingsByCollectorId(collectorId));
            return "collectorHistory"; // templates/collector-history.html
        } catch (Exception e) {
            model.addAttribute("error", "Gagal mengambil data riwayat.");
            return "collectorHistory";
        }
    }
}
