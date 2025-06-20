package com.example.TubesOOP.Controller;

import com.example.TubesOOP.entity.Collector;
import com.example.TubesOOP.payload.collector.CollectorLoginRequest;
import com.example.TubesOOP.payload.collector.CollectorRegisterRequest;
import com.example.TubesOOP.payload.collector.CollectorResponse;
import com.example.TubesOOP.service.CollectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/collector")
public class CollectorController {

    @Autowired
    private CollectorService collectorService;

    @PostMapping("/login")
    public String loginCollector(@ModelAttribute CollectorLoginRequest request) {
        try {
            Collector collector = collectorService.authenticateCollector(
                    request.getEmail(), request.getPassword()
            );
            // Login berhasil, redirect ke dashboard collector
            return "redirect:/home";
        } catch (Exception e) {
            // Login gagal, redirect ke login page dengan error
            return "redirect:/login?error";
        }
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "collectorLogin";
    }

    @PostMapping("/register")
    public String registerCollector(@ModelAttribute CollectorRegisterRequest request) {
        try {
            collectorService.registerCollector(
                    request.getUsername(),
                    request.getEmail(),
                    request.getPassword(),
                    request.getPhoneNumber(),
                    request.getAddress(),
                    request.getProfilePic()
            );
            // Registrasi berhasil, redirect ke login
            return "redirect:/login?registered";
        } catch (Exception e) {
            // Registrasi gagal, kembali ke register
            return "redirect:/register?error";
        }
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        return "collectorRegister";
    }

    @GetMapping("/profile")
    public String getCollectorInfo(@PathVariable String email) {
        try {
            Collector collector = collectorService.findCollectorByEmail(email);
            CollectorResponse response = collectorService.convertToResponse(collector);
            // Redirect ke halaman profil collector
            return "redirect:/collectorProfile";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "collectorAbout";
    }

    @GetMapping("/home")
    public String homePage() {
        return "collectorHome";
    }

    @GetMapping("/history")
    public String historyPage() {
        return "collectorHistory";
    }
}
