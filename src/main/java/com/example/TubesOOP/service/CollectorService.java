package com.example.TubesOOP.service;

import com.example.TubesOOP.entity.Collector;
import com.example.TubesOOP.repository.CollectorRepository;
import com.example.TubesOOP.payload.CollectorInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CollectorService {

    @Autowired
    private CollectorRepository repository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(16);

    // Cari collector berdasarkan email
    public Collector findCollectorByEmail(String email) throws Exception {
        Optional<Collector> collector = repository.findByEmail(email);
        if (!collector.isPresent()) {
            throw new Exception("findCollectorByEmail.Collector doesn't exist");
        }
        return collector.get();
    }

    // Autentikasi login collector
    public Collector authenticateCollector(String email, String password) throws Exception {
        Optional<Collector> collector = repository.findByEmail(email);
        if (!collector.isPresent()) {
            throw new Exception("authenticateCollector.Collector doesn't exist");
        }

        if (passwordEncoder.matches(password, collector.get().getPassword())) {
            return collector.get();
        } else {
            throw new Exception("authenticateCollector.Wrong password");
        }
    }

    // Registrasi collector baru
    public void registerCollector(String name, String email, String password, String phoneNumber, String address, String profilePic) throws Exception {
        if (repository.existsByEmail(email)) {
            throw new Exception("registerCollector.Email already used");
        }

        Collector newCollector = new Collector();
        newCollector.setName(name);
        newCollector.setEmail(email);
        newCollector.setPassword(passwordEncoder.encode(password));
        newCollector.setPhoneNumber(phoneNumber);
        newCollector.setAddress(address);
        newCollector.setProfilePic(profilePic);
        newCollector.setActive(true);

        repository.save(newCollector);
    }

    // Mengubah Collector ke bentuk response
    public CollectorInfoResponse convertToResponse(Collector collector) {
        return new CollectorInfoResponse(
                collector.getId(),
                collector.getName(),
                collector.getEmail(),
                collector.getPhoneNumber(),
                collector.getAddress(),
                collector.getProfilePic(),
                collector.getActive()
        );
    }
}
