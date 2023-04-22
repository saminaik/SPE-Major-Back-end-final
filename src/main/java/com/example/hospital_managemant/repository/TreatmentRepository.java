package com.example.hospital_managemant.repository;

import com.example.hospital_managemant.entity.Treatement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TreatmentRepository extends JpaRepository<Treatement,Long> {
    @Query("select t from Treatement t where t.appointmentId = ?1")
    List<Treatement> findByAppointmentId(Long appointmentId);
}
