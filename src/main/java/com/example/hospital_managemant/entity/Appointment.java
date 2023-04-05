package com.example.hospital_managemant.entity;
import com.example.hospital_managemant.enums.AppointmentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @Column(name = "date")
    private String date;
    @Column(name = "time")
    private String time;
    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

    public Appointment(String date, String time, AppointmentStatus status) {
        this.date = date;
        this.time = time;
        this.status = status;
    }

    public Appointment(Long doctorId, Long date, String time, String patient_id, String requested) {

    }


    // getters and setters
}
