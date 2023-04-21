package com.example.hospital_managemant.repository;

import com.example.hospital_managemant.entity.Appointment;

import com.example.hospital_managemant.enums.AppointmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    @Query("select a from Appointment a where a.doctor.id = ?1")
    List<Appointment> findByDoctor_Id(Long id);
    @Query("select a from Appointment a where a.patient.id = ?1")
    List<Appointment> findByPatient_Id(Long id);



    @Transactional
    @Modifying
    @Query("update Appointment a set a.status = ?1 where a.id = ?2")
    int updateStatusById(AppointmentStatus status, Long id);
}
