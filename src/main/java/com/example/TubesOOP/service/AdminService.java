package com.example.TubesOOP.service;

import com.example.TubesOOP.entity.Admin;
import com.example.TubesOOP.repository.AdminRepository;
import com.example.TubesOOP.payload.AdminInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository repository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(16);

    // Mencari admin berdasarkan username
    public Admin findAdminByUsername(String username) throws Exception {
        Optional<Admin> admin = repository.findByUsername(username);
        if (!admin.isPresent()) {
            throw new Exception("findAdminByUsername.Admin doesn't exist");
        }
        return admin.get();
    }

    // Mengubah objek Admin menjadi AdminInfoResponse
    public AdminInfoResponse convertToResponse(Admin admin) {
        return new AdminInfoResponse(admin.getId(), admin.getUsername(), admin.getEmail());
    }

    // Autentikasi login admin
    public Admin authenticateAdmin(String username, String password) throws Exception {
        Optional<Admin> admin = repository.findByUsername(username);
        if (!admin.isPresent()) {
            throw new Exception("authenticateAdmin.Admin doesn't exist");
        }

        if (passwordEncoder.matches(password, admin.get().getPassword())) {
            return admin.get();
        } else {
            throw new Exception("authenticateAdmin.Wrong password");
        }
    }

    // Registrasi admin baru
    public void registerAdmin(String username, String email, String password) throws Exception {
        if (repository.existsByEmail(email)) {
            throw new Exception("registerAdmin.Email already used");
        }

        if (repository.existsByUsername(username)) {
            throw new Exception("registerAdmin.Username already used");
        }

        Admin newAdmin = new Admin();
        newAdmin.setUsername(username);
        newAdmin.setEmail(email);
        newAdmin.setPassword(passwordEncoder.encode(password));

        repository.save(newAdmin);
    }
}
