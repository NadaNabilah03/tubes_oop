package com.example.TubesOOP.Controller;

import com.example.TubesOOP.entity.Collector;
import com.example.TubesOOP.payload.CollectorLoginRequest;
import com.example.TubesOOP.payload.CollectorRegisterRequest;
import com.example.TubesOOP.payload.CollectorResponse;
import com.example.TubesOOP.service.CollectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/collector")
public class CollectorController {

    @Autowired
    private CollectorService collectorService;

    @PostMapping("/login")
    public ResponseEntity<?> loginCollector(@RequestBody CollectorLoginRequest request) {
        try {
            Collector collector = collectorService.authenticateCollector(
                    request.getEmail(), request.getPassword()
            );
            CollectorResponse response = collectorService.convertToResponse(collector);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerCollector(@RequestBody CollectorRegisterRequest request) {
        try {
            collectorService.registerCollector(
                    request.getName(),
                    request.getUsername(),
                    request.getEmail(),
                    request.getPassword(),
                    request.getPhoneNumber(),
                    request.getAddress(),
                    request.getProfilePic()
            );
            return ResponseEntity.ok("Collector registered successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{email}")
    public ResponseEntity<?> getCollectorInfo(@PathVariable String email) {
        try {
            Collector collector = collectorService.findCollectorByEmail(email);
            CollectorResponse response = collectorService.convertToResponse(collector);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

