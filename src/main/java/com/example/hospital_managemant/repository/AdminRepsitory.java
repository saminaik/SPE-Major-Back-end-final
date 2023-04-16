package com.example.hospital_managemant.repository;

import com.example.hospital_managemant.entity.Admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AdminRepsitory extends JpaRepository<Admin, Long> {
    @Query("select a from Admin a where a.email = ?1")
    Optional<Admin> findByEmail(String email);
}
