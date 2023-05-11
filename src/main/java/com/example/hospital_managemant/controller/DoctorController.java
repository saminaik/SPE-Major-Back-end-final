package com.example.hospital_managemant.controller;

import com.example.hospital_managemant.entity.Appointment;
import com.example.hospital_managemant.entity.Prescription;
import com.example.hospital_managemant.entity.Treatement;
import com.example.hospital_managemant.enums.AppointmentStatus;
import com.example.hospital_managemant.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import java.util.List;

@RequestMapping("api/doctor")
@RestController
public class DoctorController {
 //   private static final Logger logger = LoggerFactory.getLogger(DoctorController.class);

    @Autowired
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    //    @PostMapping("/appoinmentApprove/{id}/{status}")
//    public ResponseEntity<?> approveAppoinment(@PathVariable Long id,@PathVariable String status){
//        try{
//            boolean b=doctorService.approveAppointmentsById(id,status);
//            return ResponseEntity.ok("Done!");
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//        return ResponseEntity.badRequest().body("not able to post the reponse");
//    }
    @GetMapping("/appointments/{id}")
    public List<Appointment> getAllAppointments(@PathVariable Long id)
    {
        List<Appointment> appointments = doctorService.getAllAppointments(id);
        System.out.println(appointments);
        if (appointments.size()==0){
           // logger.warn("No appointments found.");
            return null;}
        //logger.info("Retrieved  appointments.", appointments.size());
        return appointments;
    }
    @PostMapping("/treatment")
    public ResponseEntity<?> setTreatment(@RequestBody Treatement treat){
        //logger.info("Received request to set treatment for patient");

        return doctorService.setTreatment(treat);
    }
    @PostMapping("/pres")
    public ResponseEntity<?> setPrescription(@RequestBody Prescription prescription)
    {
        //logger.info("Received request to set prescription for Appointment with id {}.", prescription.getAppointmentId());

        return doctorService.setPriscription(prescription);
    }

    @PostMapping("appoinmentApprove/{id}/{ISAPPROVED}")
    public ResponseEntity<?> approveAppoinment(@PathVariable Long id,@PathVariable String ISAPPROVED){
        System.out.println(ISAPPROVED);
       // logger.info("Received request to approve appointment with id {}.", id);

        return doctorService.approveAppoinment(id,ISAPPROVED);
    }
}