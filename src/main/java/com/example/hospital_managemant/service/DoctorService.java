package com.example.hospital_managemant.service;



import com.example.hospital_managemant.entity.Appointment;
import com.example.hospital_managemant.entity.Doctor;
import com.example.hospital_managemant.entity.Prescription;
import com.example.hospital_managemant.entity.Treatement;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DoctorService {

    void addDoctor(Doctor doctor);
    public void deleteDoctorById(Long id);
    public List<Doctor> getAllDoctors();



    List<Appointment> getAllAppointments(Long id);

    ResponseEntity<?> setTreatment(Treatement treat);

    ResponseEntity<?> setPriscription(Prescription prescription);

    ResponseEntity<?> approveAppoinment(Long id, String str);


//    boolean approveAppointmentsById(Long id, String status);

}



