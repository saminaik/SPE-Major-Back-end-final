package com.example.hospital_managemant.service;

import com.example.hospital_managemant.DTO.PatientReplyBodyBYAdmin;
import com.example.hospital_managemant.entity.Query;

import java.util.List;

public interface AdminService {


    boolean addReply(PatientReplyBodyBYAdmin patientReplyBodyBYAdmin);

    List<Query> getquery();

    boolean adReply(String replyText, Long id);
}
