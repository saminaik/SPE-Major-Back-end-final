package com.example.hospital_managemant.repository;

import com.example.hospital_managemant.entity.Admin;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepsitory extends JpaRepository<Admin, Long> {
}
