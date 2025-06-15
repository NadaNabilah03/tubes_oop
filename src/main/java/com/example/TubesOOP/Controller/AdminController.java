package com.example.TubesOOP.controller;

import com.example.TubesOOP.entity.Admin;
import com.example.TubesOOP.payload.AdminInfoResponse;
import com.example.TubesOOP.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Login endpoint
    @PostMapping("/login")
    public ResponseEntity<?> loginAdmin(@RequestParam String username, @RequestParam String password) {
        try {
            Admin admin = adminService.authenticateAdmin(username, password);
            AdminInfoResponse response = adminService.convertToResponse(admin);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Register endpoint
    @PostMapping("/register")
    public ResponseEntity<?> registerAdmin(
            @RequestParam String username,
            @RequestParam String email,
            @RequestParam String password
    ) {
        try {
            adminService.registerAdmin(username, email, password);
            return ResponseEntity.ok("Admin registered successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Get admin info by username
    @GetMapping("/{username}")
    public ResponseEntity<?> getAdminInfo(@PathVariable String username) {
        try {
            Admin admin = adminService.findAdminByUsername(username);
            AdminInfoResponse response = adminService.convertToResponse(admin);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
