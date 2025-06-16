package com.example.TubesOOP.Controller;

import com.example.TubesOOP.entity.Admin;
import com.example.TubesOOP.payload.AdminInfoResponse;
import com.example.TubesOOP.payload.AdminLoginRequest;
import com.example.TubesOOP.payload.AdminRegisterRequest;
import com.example.TubesOOP.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public String loginAdmin(@RequestBody AdminLoginRequest request) {
        try {
            Admin admin = adminService.authenticateAdmin(request.getEmail(), request.getPassword());

            return "redirect:/admin-dashboard";
        } catch (Exception e) {
            return "redirect:/login?error";
        }
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/register")
    public String registerAdmin(@RequestBody AdminRegisterRequest request) {
        try {
            adminService.registerAdmin(request.getUsername(), request.getEmail(), request.getPassword());
            return "redirect:/login?registered";
        } catch (Exception e) {
            return "redirect:/register?error";
        }
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }

    @GetMapping("/{email}")
    public String getAdminInfo(@PathVariable String email) {
        try {
            return "redirect:/profile";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }
}
