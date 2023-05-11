package com.example.hospital_managemant.controller;

import com.example.hospital_managemant.DTO.PatientReplyBodyBYAdmin;
import com.example.hospital_managemant.entity.Doctor;
import com.example.hospital_managemant.entity.Patient;
import com.example.hospital_managemant.entity.Query;
import com.example.hospital_managemant.service.AdminService;
import com.example.hospital_managemant.service.DoctorService;
import com.example.hospital_managemant.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;

//@RestController

@RequestMapping("/api/admin")
@RestController
@CrossOrigin("http://localhost:3000")
public class AdminController {
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    private final DoctorService doctorService;
    private final AdminService adminService;
    private final PatientService patientService;
    public AdminController(DoctorService doctorService, AdminService adminService, PatientService patientService) {
        this.doctorService = doctorService;
        this.adminService = adminService;
        this.patientService = patientService;
    }

    @PostMapping("/reply-query")
    public ResponseEntity<?> replyQuery(@RequestBody PatientReplyBodyBYAdmin patientReplyBodyBYAdmin){
        boolean b=adminService.addReply(patientReplyBodyBYAdmin);
        if(b)
            return ResponseEntity.ok("Done!");
        else return ResponseEntity.badRequest().body("not able to post the reponse");
    }
    @PostMapping("/reply-querys/{id}")
    public ResponseEntity<?> replyQ(@RequestBody String replyText,@PathVariable Long id){
        boolean b=adminService.adReply(replyText,id);
        if(b){logger.info("Replied Successfully");
            return ResponseEntity.ok("Done!");}
        else { logger.error("not able to reply the query");
            return ResponseEntity.badRequest().body("not able to post the reponse");}
    }
  @GetMapping("/quries")
  public List<Query> getquery(){
        return adminService.getquery();
  }


    @PostMapping("/doctor")
    public void addDoctor(@RequestBody Doctor doctor) {
        doctorService.addDoctor(doctor);
    }
    @DeleteMapping("/doctor/{id}")
    public void deleteDoctor(@PathVariable Long id){
        doctorService.deleteDoctorById(id);
    }
    @GetMapping("/doctors")
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }
   @GetMapping("/patients")
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
   }
}