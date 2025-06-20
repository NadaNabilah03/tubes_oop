package com.example.TubesOOP.service;

import com.example.TubesOOP.entity.Collector;
import com.example.TubesOOP.payload.collector.CollectorResponse;
import com.example.TubesOOP.repository.CollectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CollectorService {

    @Autowired
    private CollectorRepository collectorRepository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(16);

    public Collector authenticateCollector(String email, String password) throws Exception {
        Optional<Collector> collector = collectorRepository.findByEmail(email);
        if (!collector.isPresent()) {
            throw new Exception("Collector with this email does not exist");
        }

        if (!passwordEncoder.matches(password, collector.get().getPassword())) {
            throw new Exception("Wrong password");
        }

        return collector.get();
    }

    public Collector registerCollector(String username, String email, String password,
                                       String phoneNumber, String address, String profilePic) {

        // Validasi
        if (collectorRepository.existsByUsername(username)) {
            throw new RuntimeException("Username sudah digunakan");
        }

        if (collectorRepository.existsByEmail(email)) {
            throw new RuntimeException("Email sudah terdaftar");
        }

        Collector collector = new Collector();
        collector.setUsername(username);
        collector.setEmail(email);
        collector.setPassword(passwordEncoder.encode(password)); // pakai encoder!
        collector.setPhoneNumber(phoneNumber);
        collector.setAddress(address);
        collector.setProfilePic(profilePic);

        if (profilePic == null || profilePic.isEmpty()) {
            collector.setProfilePic("/image/avatar.jpg");
        } else {
            collector.setProfilePic(profilePic);
        }

        return collectorRepository.save(collector);
    }


    public Collector findCollectorByEmail(String email) throws Exception {
        Optional<Collector> collector = collectorRepository.findByEmail(email);
        if (!collector.isPresent()) {
            throw new Exception("Collector with this email not found");
        }
        return collector.get();
    }

    public CollectorResponse convertToResponse(Collector collector) {
        return new CollectorResponse(
                collector.getCollectorId(),
                collector.getUsername(),
                collector.getEmail(),
                collector.getAddress(),
                collector.getPhoneNumber(),
                collector.getActive()
        );
    }

}
