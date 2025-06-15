package com.example.TubesOOP.controller;

import com.example.TubesOOP.entity.Customer;
import com.example.TubesOOP.payload.CustomerInfoResponse;
import com.example.TubesOOP.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // Login Customer
    @PostMapping("/login")
    public ResponseEntity<?> loginCustomer(@RequestParam String username, @RequestParam String password) {
        try {
            Customer customer = customerService.authenticateCustomer(username, password);
            CustomerInfoResponse response = customerService.convertToResponse(customer);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Register Customer
    @PostMapping("/register")
    public ResponseEntity<?> registerCustomer(
            @RequestParam String username,
            @RequestParam String email,
            @RequestParam String password
    ) {
        try {
            customerService.registerCustomer(username, email, password);
            return ResponseEntity.ok("Customer registered successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Get Customer Info by Username
    @GetMapping("/{username}")
    public ResponseEntity<?> getCustomerInfo(@PathVariable String username) {
        try {
            Customer customer = customerService.findCustomerByUsername(username);
            CustomerInfoResponse response = customerService.convertToResponse(customer);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
