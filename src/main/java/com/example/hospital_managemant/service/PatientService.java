package com.example.hospital_managemant.service;

import com.example.hospital_managemant.DRO.BookAppointmentBody;
import com.example.hospital_managemant.DRO.PatientQueryBody;
import com.example.hospital_managemant.entity.Appointment;
import com.example.hospital_managemant.entity.Patient;
import com.example.hospital_managemant.entity.Prescription;
import org.hibernate.query.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface PatientService {
    void registerPatient(Patient patient);

    public List<Patient> getAllPatients();





    Appointment bookAppointment(Long patientId, Appointment appointment);

    boolean addQuery(PatientQueryBody patientQueryBody);

    boolean bookAppointment(BookAppointmentBody bookAppointmentBody);
}
