package com.example.hospital_managemant.repository;

import com.example.hospital_managemant.entity.Appointment;

import com.example.hospital_managemant.enums.AppointmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {




}
