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
        long startTime = System.currentTimeMillis(); // record start time
        boolean b=adminService.adReply(replyText,id);
        long endTime = System.currentTimeMillis(); // record end time
        long requestTime = endTime - startTime; // calculate request time
        if(b){logger.info("API: /reply-query/id, Response state: OK, Request time: " + requestTime + "ms");

            return ResponseEntity.ok("Done!");}
        else { logger.info("API: /reply-query/id, Response state: error, Request time: " + requestTime + "ms");
            return ResponseEntity.badRequest().body("not able to post the reponse");}
    }
  @GetMapping("/quries")
  public List<Query> getquery(){


      long startTime = System.currentTimeMillis(); // record start time
      List<Query> q= adminService.getquery();
      long endTime = System.currentTimeMillis(); // record end time
      long requestTime = endTime - startTime; // calculate request time
      logger.info("API: /doctor, Response state: OK, Request time: " + requestTime + "ms");

      return q;
  }


    @PostMapping("/doctor")
    public void addDoctor(@RequestBody Doctor doctor) {
        long startTime = System.currentTimeMillis(); // record start time
        doctorService.addDoctor(doctor);
        long endTime = System.currentTimeMillis(); // record end time
        long requestTime = endTime - startTime; // calculate request time
        logger.info("API: /doctor, Response state: OK, Request time: " + requestTime + "ms");
    }
    @DeleteMapping("/doctor/{id}")
    public void deleteDoctor(@PathVariable Long id){

        long startTime = System.currentTimeMillis(); // record start time
        doctorService.deleteDoctorById(id);
        long endTime = System.currentTimeMillis(); // record end time
        long requestTime = endTime - startTime; // calculate request time
        logger.info("API: /doctor/id, Response state: OK, Request time: " + requestTime + "ms");
    }
    @GetMapping("/doctors")
    public List<Doctor> getAllDoctors(){
        long startTime = System.currentTimeMillis();
        List<Doctor> d=doctorService.getAllDoctors();
        long endTime = System.currentTimeMillis(); // record end time
        long requestTime = endTime - startTime; // calculate request time
        logger.info("API: /doctors, Response state: OK, Request time: " + requestTime + "ms");
        return d;
    }
   @GetMapping("/patients")
    public List<Patient> getAllPatients(){
       long startTime = System.currentTimeMillis();
        List<Patient> p= patientService.getAllPatients();
       long endTime = System.currentTimeMillis(); // record end time
       long requestTime = endTime - startTime; // calculate request time
       logger.info("API: /doctors, Response state: OK, Request time: " + requestTime + "ms");
        return p;
   }
}