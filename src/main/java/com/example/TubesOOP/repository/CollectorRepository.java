package com.example.TubesOOP.repository;

import com.example.TubesOOP.entity.Collector;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CollectorRepository extends JpaRepository<Collector, Long> {
    Optional<Collector> findByEmail(String email);
    Optional<Collector> findByName(String name);
    boolean existsByEmail(String email);
    boolean existsByName(String name);
}
