package com.example.TubesOOP.Controller;

import com.example.TubesOOP.entity.Customer;
import com.example.TubesOOP.payload.CustomerLoginRequest;
import com.example.TubesOOP.payload.CustomerRegisterRequest;
import com.example.TubesOOP.payload.CustomerResponse;
import com.example.TubesOOP.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/login")
    public ResponseEntity<?> loginCustomer(@RequestBody CustomerLoginRequest request) {
        try {
            Customer customer = customerService.authenticateCustomer(
                    request.getEmail(), request.getPassword()
            );
            CustomerResponse response = customerService.convertToResponse(customer);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerCustomer(@RequestBody CustomerRegisterRequest request) {
        try {
            customerService.registerCustomer(request.getUsername(), request.getEmail(), request.getPassword());
            return ResponseEntity.ok("Customer registered successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getCustomerInfo(@PathVariable String username) {
        try {
            Customer customer = customerService.findCustomerByUsername(username);
            CustomerResponse response = customerService.convertToResponse(customer);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
