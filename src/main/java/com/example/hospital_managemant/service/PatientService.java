package com.example.hospital_managemant.service;

import com.example.hospital_managemant.DRO.BookAppointmentBody;
import com.example.hospital_managemant.DRO.PatientQueryBody;
import com.example.hospital_managemant.entity.Appointment;
import com.example.hospital_managemant.entity.Patient;
import com.example.hospital_managemant.entity.Prescription;
import com.example.hospital_managemant.entity.Treatement;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PatientService {
   Patient registerPatient(Patient patient);

    public List<Patient> getAllPatients();





//    Appointment bookAppointment(Long patientId, Appointment appointment);

    boolean addQuery(PatientQueryBody patientQueryBody);

    ResponseEntity<?> bookAppointment(BookAppointmentBody bookAppointmentBody);

    List<Appointment> getAppointment(Long id);

    List<Prescription> getPrescription(Long id);

    List<Appointment> getApproved(Long id);

    List<Treatement> getTreatment(Long id);
}
