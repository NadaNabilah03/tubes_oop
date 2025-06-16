package com.example.TubesOOP.Controller;

import com.example.TubesOOP.entity.Customer;
import com.example.TubesOOP.payload.CustomerLoginRequest;
import com.example.TubesOOP.payload.CustomerRegisterRequest;
import com.example.TubesOOP.payload.CustomerResponse;
import com.example.TubesOOP.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/login")
    public String loginCustomer(@RequestBody CustomerLoginRequest request) {
        try {
            Customer customer = customerService.authenticateCustomer(
                    request.getEmail(), request.getPassword()
            );
            CustomerResponse response = customerService.convertToResponse(customer);
            return "redirect:/home";
        } catch (Exception e) {
            return "redirect:/login?error";
        }
    }

    @PostMapping("/register")
    public String registerCustomer(@RequestBody CustomerRegisterRequest request) {
        try {
            customerService.registerCustomer(request.getUsername(), request.getEmail(), request.getPassword());
            return "redirect:/login?registered";
        } catch (Exception e) {
            return "redirect:/register?error";
        }
    }

    @GetMapping("/{username}")
    public String getCustomerInfo(@PathVariable String username) {
        try {
            Customer customer = customerService.findCustomerByUsername(username);
            CustomerResponse response = customerService.convertToResponse(customer);
            return "redirect:/profile";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }
}
