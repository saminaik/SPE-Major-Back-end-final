package com.example.hospital_managemant.service;

import com.example.hospital_managemant.DRO.BookAppointmentBody;
import com.example.hospital_managemant.DRO.PatientQueryBody;
import com.example.hospital_managemant.entity.Appointment;
import com.example.hospital_managemant.entity.Patient;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    void registerPatient(Patient patient);

    public List<Patient> getAllPatients();





//    Appointment bookAppointment(Long patientId, Appointment appointment);

    boolean addQuery(PatientQueryBody patientQueryBody);

    ResponseEntity<?> bookAppointment(BookAppointmentBody bookAppointmentBody);

    List<Appointment> getAppointment(Long id);
}
