package com.example.hospital_managemant.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Treatement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long appointmentId;
    private String diagnosis;
    private String  diet;
    private Long   doctorId;
    private String patientName;
    private String symptoms;

    public Treatement(Long appointmentId, String diagnosis, String diet, Long doctorId, String patientName, String symptoms) {
        this.appointmentId = appointmentId;
        this.diagnosis = diagnosis;
        this.diet = diet;
        this.doctorId = doctorId;
        this.patientName = patientName;
        this.symptoms = symptoms;
    }
}
