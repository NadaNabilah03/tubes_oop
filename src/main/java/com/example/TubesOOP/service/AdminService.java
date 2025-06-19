package com.example.TubesOOP.service;

import com.example.TubesOOP.entity.Admin;
import com.example.TubesOOP.payload.admin.AdminInfoResponse;
import com.example.TubesOOP.payload.admin.AdminRegisterResponse;
import com.example.TubesOOP.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(16);

    public Admin authenticateAdmin(String email, String password) throws Exception {
        Optional<Admin> admin = adminRepository.findByEmail(email);
        if (!admin.isPresent()) {
            throw new Exception("Admin with this email does not exist");
        }

        if (!passwordEncoder.matches(password, admin.get().getPassword())) {
            throw new Exception("Wrong password");
        }

        return admin.get();
    }

    public AdminRegisterResponse registerAdmin(String username, String email, String password, String profilePic) throws Exception {
        if (adminRepository.existsByEmail(email)) {
            throw new Exception("Email already used");
        }

        if (adminRepository.existsByUsername(username)) {
            throw new Exception("Username already used");
        }

        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setEmail(email);
        admin.setPassword(passwordEncoder.encode(password));
        admin.setProfilePic(profilePic);

        return new AdminRegisterResponse(
                admin.getAdminId(),
                admin.getUsername(),
                admin.getEmail(),
                admin.getProfilePic()
        );
    }



    public AdminInfoResponse getAdminInfo(String email) throws Exception {
        Admin admin = findAdminByEmail(email); // pake method yg udah ada
        return convertToResponse(admin);       // ubah ke response
    }

    public Admin findAdminByEmail(String email) throws Exception {
        Optional<Admin> admin = adminRepository.findByEmail(email);
        if (!admin.isPresent()) {
            throw new Exception("Admin with this email not found");
        }
        return admin.get();
    }

    public AdminInfoResponse convertToResponse(Admin admin) {
        return new AdminInfoResponse(
                admin.getAdminId(),
                admin.getUsername(),
                admin.getEmail()
        );
    }



}
