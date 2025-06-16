package com.example.TubesOOP.Controller;

import com.example.TubesOOP.service.FormulirBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/history")
public class HistoryBookingController {

    @Autowired
    private FormulirBookingService bookingService;

    @GetMapping("/customer/{customerId}")
    public String getCustomerHistory(@PathVariable Long customerId) {
        try {
            bookingService.getBookingsByCustomerId(customerId);
            return "redirect:/history"; // Halaman history customer
        } catch (Exception e) {
            return "redirect:/history?error";
        }
    }

    @GetMapping("/collector/{collectorId}")
    public String getCollectorHistory(@PathVariable Long collectorId) {
        try {
            bookingService.getBookingsByCollectorId(collectorId);
            return "redirect:/collector/history"; // Halaman history collector
        } catch (Exception e) {
            return "redirect:/collector/history?error";
        }
    }
}
