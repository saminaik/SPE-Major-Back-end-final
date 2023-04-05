package com.example.hospital_managemant.repository;

import com.example.hospital_managemant.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
}
