package com.example.hospital_managemant.repository;

import com.example.hospital_managemant.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
    @Query("select p from Prescription p where p.appointmentId = ?1")
    List<Prescription> findByAppointmentId(Long appointmentId);
}
