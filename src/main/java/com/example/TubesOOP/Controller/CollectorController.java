package com.example.TubesOOP.Controller;

import com.example.TubesOOP.entity.Collector;
import com.example.TubesOOP.entity.Customer;
import com.example.TubesOOP.payload.collector.CollectorLoginRequest;
import com.example.TubesOOP.payload.collector.CollectorRegisterRequest;
import com.example.TubesOOP.payload.collector.CollectorResponse;
import com.example.TubesOOP.payload.customer.CustomerLoginRequest;
import com.example.TubesOOP.payload.customer.CustomerResponse;
import com.example.TubesOOP.service.CollectorService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/collector")
public class CollectorController {

    @Autowired
    private CollectorService collectorService;

    @PostMapping("/login")
    public String loginCustomer(@ModelAttribute CollectorLoginRequest request, HttpSession session) {
        try {
            Collector collector = collectorService.authenticateCollector(
                    request.getEmail(), request.getPassword()
            );
            CollectorResponse response = collectorService.convertToResponse(collector);

            session.setAttribute("loggedInCollector", response);

            return "redirect:/collector/home";
        } catch (Exception e) {
            return "redirect:/collector/login?error";
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
            return "redirect:/collector/login?registered=true";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/collector/register?error";
        }
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        return "collectorRegister";
    }

    @GetMapping("/profile")
    public String getCollectorInfo(HttpSession session, Model model) {
        CollectorResponse collector = (CollectorResponse) session.getAttribute("loggedInCollector");

        System.out.println("DEBUG /profile - session.loggedInCustomer = " + collector);

        if (collector == null) {
            return "redirect:/customer/login?unauthorized";
        }

        model.addAttribute("customer", collector);
        return "customerProfile";
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
