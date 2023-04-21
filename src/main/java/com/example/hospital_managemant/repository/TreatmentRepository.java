package com.example.hospital_managemant.repository;

import com.example.hospital_managemant.entity.Treatement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreatmentRepository extends JpaRepository<Treatement,Long> {
}
