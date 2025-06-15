<<<<<<< HEAD
package com.example.TubesOOP.service;

import com.example.TubesOOP.entity.Customer;
import com.example.TubesOOP.repository.CustomerRepository;
import com.example.TubesOOP.payload.CustomerInfoResponse;
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

    // Mengubah objek Customer menjadi CustomerInfoResponse
    public CustomerInfoResponse convertToResponse(Customer customer) {
        return new CustomerInfoResponse(customer.getId(), customer.getUsername(), customer.getEmail());
    }

    // Autentikasi login customer
    public Customer authenticateCustomer(String username, String password) throws Exception {
        Optional<Customer> customer = repository.findByUsername(username);
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
    public void registerCustomer(String username, String email, String password) throws Exception {
        if (repository.existsByEmail(email)) {
            throw new Exception("registerCustomer.Email already used");
        }

        if (repository.existsByUsername(username)) {
            throw new Exception("registerCustomer.Username already used");
        }

        Customer newCustomer = new Customer();
        newCustomer.setUsername(username);
        newCustomer.setEmail(email);
        newCustomer.setPassword(passwordEncoder.encode(password));

        repository.save(newCustomer);
    }
}
=======
package com.example.TubesOOP.service;

import com.example.TubesOOP.entity.Customer;
import com.example.TubesOOP.repository.CustomerRepository;
import com.example.TubesOOP.payload.CustomerInfoResponse;
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

    // Mengubah objek Customer menjadi CustomerInfoResponse
    public CustomerInfoResponse convertToResponse(Customer customer) {
        return new CustomerInfoResponse(customer.getId(), customer.getUsername(), customer.getEmail());
    }

    // Autentikasi login customer
    public Customer authenticateCustomer(String username, String password) throws Exception {
        Optional<Customer> customer = repository.findByUsername(username);
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
    public void registerCustomer(String username, String email, String password) throws Exception {
        if (repository.existsByEmail(email)) {
            throw new Exception("registerCustomer.Email already used");
        }

        if (repository.existsByUsername(username)) {
            throw new Exception("registerCustomer.Username already used");
        }

        Customer newCustomer = new Customer();
        newCustomer.setUsername(username);
        newCustomer.setEmail(email);
        newCustomer.setPassword(passwordEncoder.encode(password));

        repository.save(newCustomer);
    }
}
>>>>>>> 91f24e28f179339d6805b090435767b894ba3a26
