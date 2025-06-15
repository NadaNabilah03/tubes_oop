package com.example.TubesOOP.controller;

import com.example.TubesOOP.entity.Collector;
import com.example.TubesOOP.payload.CollectorInfoResponse;
import com.example.TubesOOP.service.CollectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/collector")
public class CollectorController {

    @Autowired
    private CollectorService collectorService;

    // Login Collector
    @PostMapping("/login")
    public ResponseEntity<?> loginCollector(@RequestParam String email, @RequestParam String password) {
        try {
            Collector collector = collectorService.authenticateCollector(email, password);
            CollectorInfoResponse response = collectorService.convertToResponse(collector);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Register Collector
    @PostMapping("/register")
    public ResponseEntity<?> registerCollector(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String phoneNumber,
            @RequestParam String address,
            @RequestParam(required = false) String profilePic
    ) {
        try {
            collectorService.registerCollector(name, email, password, phoneNumber, address, profilePic);
            return ResponseEntity.ok("Collector registered successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Get Collector Info by Email
    @GetMapping("/{email}")
    public ResponseEntity<?> getCollectorInfo(@PathVariable String email) {
        try {
            Collector collector = collectorService.findCollectorByEmail(email);
            CollectorInfoResponse response = collectorService.convertToResponse(collector);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
