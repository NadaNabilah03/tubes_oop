package com.example.TubesOOP.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    // Redirect to login
    @GetMapping("/")
    public String index() {
        return "index";
    }

    // Auth routes
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    // Main application routes
    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/history")
    public String history(Model model) {
        // Add model attributes if needed
        // model.addAttribute("bookings", bookingService.getUserBookings());
        return "history";
    }

    @GetMapping("/form")
    public String bookingForm(Model model) {
        // Initialize form data if needed
        return "form";
    }

    // Profile routes
    @GetMapping("/profile")
    public String profile(Model model) {
        // Add user data to model
        // model.addAttribute("user", userService.getCurrentUser());
        return "profile";
    }

    // Admin routes
    @GetMapping("/admin-dashboard")
    public String adminDashboard(Model model) {
        // Add admin data to model
        // model.addAttribute("bookings", bookingService.getAllBookings());
        return "admin-dashboard";
    }

    // Error handling
    @GetMapping("/error")
    public String error() {
        return "error"; // You should create an error.html template
    }
}