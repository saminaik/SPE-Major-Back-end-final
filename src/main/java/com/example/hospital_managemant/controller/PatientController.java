package com.example.hospital_managemant.controller;

import com.example.hospital_managemant.DRO.BookAppointmentBody;
import com.example.hospital_managemant.DRO.PatientQueryBody;
import com.example.hospital_managemant.entity.Appointment;
import com.example.hospital_managemant.entity.Patient;
import com.example.hospital_managemant.service.PatientService;
import jakarta.validation.Valid;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/patients")
@RestController
public class PatientController {
    @Autowired
    private PatientService patientService;
    @PostMapping("/add-query")
    public ResponseEntity<?> addQuery(@RequestBody PatientQueryBody patientQueryBody){
        boolean b = patientService.addQuery(patientQueryBody);
        if(b)
            return ResponseEntity.ok("Query regiusterrd");
        else return ResponseEntity.badRequest().body("not able to query try after some time");
    }
    @PostMapping("/register")
    public ResponseEntity<String> registerPatient(@RequestBody Patient patient) {

        patientService.registerPatient(patient);
        return ResponseEntity.ok("Patient registered successfully");
    }

    @GetMapping("/hello")
    public String hello(){
//        return ResponseEntity.ok("Hello");
        return "hello";
    }
    @PostMapping("/appointments/book")
    public ResponseEntity<?>  bookAppointment(@RequestBody BookAppointmentBody bookAppointmentBody){
        boolean b=patientService.bookAppointment(bookAppointmentBody);
        if(b) return ResponseEntity.ok("requested appointment");
        else return ResponseEntity.badRequest().body("not able to book");
    }

    @PostMapping("/{patientId}/appointments")
    public Appointment bookAppointment(@PathVariable Long patientId, @RequestBody Appointment appointment) {
        return patientService.bookAppointment(patientId, appointment);
    }





}