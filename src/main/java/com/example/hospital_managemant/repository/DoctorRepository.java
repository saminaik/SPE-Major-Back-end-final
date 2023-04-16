package com.example.hospital_managemant.repository;


import com.example.hospital_managemant.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    @Query("select d from Doctor d where d.email = ?1")
    Optional<Doctor> findByEmail(String email);
}
