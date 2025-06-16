package com.example.TubesOOP.Controller;

import com.example.TubesOOP.entity.Admin;
import com.example.TubesOOP.payload.AdminInfoResponse;
import com.example.TubesOOP.payload.AdminLoginRequest;
import com.example.TubesOOP.payload.AdminRegisterRequest;
import com.example.TubesOOP.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public ResponseEntity<?> loginAdmin(@RequestBody AdminLoginRequest request) {
        try {
            Admin admin = adminService.authenticateAdmin(request.getEmail(), request.getPassword());
            AdminInfoResponse response = adminService.convertToResponse(admin);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerAdmin(@RequestBody AdminRegisterRequest request) {
        try {
            adminService.registerAdmin(request.getUsername(), request.getEmail(), request.getPassword());
            return ResponseEntity.ok("Admin registered successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{email}")
    public ResponseEntity<?> getAdminInfo(@PathVariable String email) {
        try {
            Admin admin = adminService.findAdminByEmail(email);
            AdminInfoResponse response = adminService.convertToResponse(admin);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

