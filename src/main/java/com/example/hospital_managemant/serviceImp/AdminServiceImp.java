package com.example.hospital_managemant.serviceImp;

import com.example.hospital_managemant.DTO.PatientReplyBodyBYAdmin;
import com.example.hospital_managemant.repository.QueryRepository;
import com.example.hospital_managemant.service.AdminService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AdminServiceImp implements AdminService {
    private final QueryRepository queryRepository;

    public AdminServiceImp(QueryRepository queryRepository) {
        this.queryRepository = queryRepository;
    }

    @Override
    public boolean addReply(PatientReplyBodyBYAdmin patientReplyBodyBYAdmin) {
       try{

                 queryRepository.updateReplyTextBy(patientReplyBodyBYAdmin.getQuery());

       return true;

       }
       catch (Exception e){
           System.out.println(e);
       }
        return false;
    }
}
