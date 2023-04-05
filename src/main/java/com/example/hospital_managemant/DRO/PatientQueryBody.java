package com.example.hospital_managemant.DRO;

public class PatientQueryBody {
    private Long patinet_id;
    private String query;
    private String subject;

    public Long getPatinet_id() {
        return patinet_id;
    }

    public String getQuery() {
        return query;
    }

    public String getSubject() {
        return subject;
    }
}
