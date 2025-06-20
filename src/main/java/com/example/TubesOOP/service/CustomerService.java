package com.example.TubesOOP.service;

import com.example.TubesOOP.entity.Customer;
import com.example.TubesOOP.repository.CustomerRepository;
import com.example.TubesOOP.payload.customer.CustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(16);

    // Mencari customer berdasarkan username
    public Customer findCustomerByUsername(String username) throws Exception {
        Optional<Customer> customer = repository.findByUsername(username);
        if (!customer.isPresent()) {
            throw new Exception("findCustomerByUsername.Customer doesn't exist");
        }
        return customer.get();
    }

    // Mengubah objek Customer menjadi CustomerResponse
    public CustomerResponse convertToResponse(Customer customer) {
        return new CustomerResponse(
                customer.getCustomerId(),  // Changed from getId() to getCustomerId()
                customer.getUsername(),
                customer.getEmail(),
                customer.getAddress(),
                customer.getPhoneNumber()
        );
    }

    // Autentikasi login customer
    public Customer authenticateCustomer(String email, String password) throws Exception {
        Optional<Customer> customer = repository.findByEmail(email);
        if (!customer.isPresent()) {
            throw new Exception("authenticateCustomer.Customer doesn't exist");
        }

        if (passwordEncoder.matches(password, customer.get().getPassword())) {
            return customer.get();
        } else {
            throw new Exception("authenticateCustomer.Wrong password");
        }
    }

    // Registrasi customer baru
    public void registerCustomer(String username, String email, String password, String address, String phoneNumber, String profilePic) throws Exception {
        if (repository.existsByEmail(email)) {
            throw new Exception("registerCustomer.Email already used");
        }

        if (repository.existsByUsername(username)) {
            throw new Exception("registerCustomer.Username already used");
        }

        Customer newCustomer = new Customer(
                username,
                email,
                passwordEncoder.encode(password),
                phoneNumber,
                address,
                profilePic != null ? profilePic : "/image/avatar.jpg"
        );

        repository.save(newCustomer);
    }

    // Update data customer
    public void updateCustomer(Long id, String username, String email, String phoneNumber, String address) throws Exception {
        Optional<Customer> optionalCustomer = repository.findById(id);

        if (!optionalCustomer.isPresent()) {
            throw new Exception("updateCustomer.Customer not found");
        }

        Customer customer = optionalCustomer.get();

        // Update data
        customer.setUsername(username);
        customer.setEmail(email);
        customer.setPhoneNumber(phoneNumber);
        customer.setAddress(address);

        repository.save(customer); // Simpan perubahan
    }

    public Customer findCustomerByEmail(String email) throws Exception {
        Optional<Customer> customer = repository.findByEmail(email);
        if (!customer.isPresent()) {
            throw new Exception("Customer not found");
        }
        return customer.get();
    }

}

