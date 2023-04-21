package com.example.hospital_managemant.entity;
import com.example.hospital_managemant.enums.AppointmentStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "appointments",
              uniqueConstraints =
              @UniqueConstraint(name = "unique-appoinments",columnNames = {"patient_id","doctor_id","date"})
)
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    @JsonBackReference
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    @JsonBackReference
    private Doctor doctor;

    @Column(name = "date")
    private String date;
   private String patient_name;
    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

    public Appointment(String date, AppointmentStatus status) {
        this.date = date;

        this.status = status;
    }

    public Appointment(Long doctorId, Long date, String time, String patient_id, String requested) {

    }

    public Long getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public String getDate() {
        return date;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

// getters and setters
}
