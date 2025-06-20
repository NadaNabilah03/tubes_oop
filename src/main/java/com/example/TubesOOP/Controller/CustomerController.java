package com.example.TubesOOP.Controller;

import com.example.TubesOOP.entity.Customer;
import com.example.TubesOOP.payload.customer.CustomerLoginRequest;
import com.example.TubesOOP.payload.customer.CustomerRegisterRequest;
import com.example.TubesOOP.payload.customer.CustomerResponse;
import com.example.TubesOOP.service.CustomerService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/login")
    public String loginCustomer(@ModelAttribute CustomerLoginRequest request, HttpSession session) {
        try {
            Customer customer = customerService.authenticateCustomer(
                    request.getEmail(), request.getPassword()
            );
            CustomerResponse response = customerService.convertToResponse(customer);

            session.setAttribute("loggedInCustomer", response);

            return "redirect:/customer/home";
        } catch (Exception e) {
            return "redirect:/customer/login?error";
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
            return "redirect:/customer/login?registered=true";
        } catch (Exception e) {
            return "redirect:/customer/register?error";
        }
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        return "customerRegister";
    }

    @GetMapping("/profile")
    public String getCustomerInfo(HttpSession session, Model model) {
        CustomerResponse customer = (CustomerResponse) session.getAttribute("loggedInCustomer");

        System.out.println("DEBUG /profile - session.loggedInCustomer = " + customer);

        if (customer == null) {
            return "redirect:/customer/login?unauthorized";
        }

        model.addAttribute("customer", customer);
        return "customerProfile";
    }




    @GetMapping("/about")
    public String aboutPage() {
        return "customerAbout";
    }

    @GetMapping("/home")
    public String homePage(HttpSession session, Model model) {
        CustomerResponse customer = (CustomerResponse) session.getAttribute("loggedInCustomer");

        if (customer == null) {
            return "redirect:/customer/login"; // belum login
        }

        model.addAttribute("customer", customer); // lempar ke HTML
        return "customerHome";
    }


    @GetMapping("/history")
    public String historyPage() {
        return "customerHistory";
    }

    @GetMapping("/form")
    public String showCustomerForm(HttpSession session, Model model) {
        CustomerResponse customer = (CustomerResponse) session.getAttribute("loggedInCustomer");

        if (customer == null) {
            return "redirect:/customer/login";
        }

        model.addAttribute("customer", customer);
        return "form"; // file HTML-nya: customerForm.html
    }

    @PostMapping("/formSubmit")
    public String submitCustomerForm(@ModelAttribute CustomerResponse request, HttpSession session) {
        try {
            CustomerResponse current = (CustomerResponse) session.getAttribute("loggedInCustomer");

            if (current == null) {
                return "redirect:/customer/login";
            }

            // Update data di database
            customerService.updateCustomer(
                    current.getId(),
                    request.getUsername(),
                    request.getEmail(),
                    request.getPhoneNumber(),
                    request.getAddress()
            );

            session.setAttribute("loggedInCustomer", request);

            return "redirect:/customer/profile?updated";
        } catch (Exception e) {
            return "redirect:/customer/form?error";
        }
    }

}
