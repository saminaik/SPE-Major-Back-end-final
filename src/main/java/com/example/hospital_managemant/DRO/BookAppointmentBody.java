package com.example.hospital_managemant.DRO;

import java.time.LocalDateTime;

public class BookAppointmentBody {
    private Long doctorId;
    private String date;

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

    @Override
    public String toString() {
        return "BookAppointmentBody{" +
                "doctorId=" + doctorId +
                ", date='" + date + '\'' +
                ", patient_id=" + patient_id +
                '}';
    }
}
