package com.example.hospital_managemant.service;



import com.example.hospital_managemant.entity.Doctor;

import java.util.List;

public interface DoctorService {
    void addDoctor(Doctor doctor);
    public void deleteDoctorById(Long id);
    public List<Doctor> getAllDoctors();

}
