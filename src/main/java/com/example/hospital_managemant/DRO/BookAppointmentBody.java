package com.example.hospital_managemant.DRO;

import java.time.LocalDateTime;

public class BookAppointmentBody {
    private Long doctorId;
    private String date;
    private String time;
    private Long patient_id;

    public Long getPatient_id() {
        return patient_id;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
