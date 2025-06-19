package com.example.TubesOOP.Controller;

import com.example.TubesOOP.entity.Customer;
import com.example.TubesOOP.payload.customer.CustomerLoginRequest;
import com.example.TubesOOP.payload.customer.CustomerRegisterRequest;
import com.example.TubesOOP.payload.customer.CustomerResponse;
import com.example.TubesOOP.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/login")
    public String loginCustomer(@ModelAttribute CustomerLoginRequest request) {
        try {
            Customer customer = customerService.authenticateCustomer(
                    request.getEmail(), request.getPassword()
            );
            CustomerResponse response = customerService.convertToResponse(customer);
            return "redirect:/customerHome";
        } catch (Exception e) {
            return "redirect:/login?error";
        }
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "customerLogin";
    }

    @PostMapping("/register")
    public String registerCustomer(@ModelAttribute CustomerRegisterRequest request) {
        try {
            customerService.registerCustomer(
                    request.getUsername(),
                    request.getEmail(),
                    request.getPassword(),
                    request.getAddress(),
                    request.getPhoneNumber(),
                    null
            );
            return "redirect:/login?registered";
        } catch (Exception e) {
            return "redirect:/register?error";
        }
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        return "customerRegister";
    }

    @GetMapping("/{username}")
    public String getCustomerInfo(@PathVariable String username) {
        try {
            Customer customer = customerService.findCustomerByUsername(username);
            CustomerResponse response = customerService.convertToResponse(customer);
            return "redirect:/customerProfile";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "customerAbout";
    }

    @GetMapping("/home")
    public String homePage() {
        return "customerHome";
    }

    @GetMapping("/history")
    public String historyPage() {
        return "customerHistory";
    }
}
