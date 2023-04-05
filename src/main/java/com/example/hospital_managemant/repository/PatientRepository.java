package com.example.hospital_managemant.repository;

import com.example.hospital_managemant.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
