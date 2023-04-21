package com.example.hospital_managemant.controller;

import com.example.hospital_managemant.DRO.BookAppointmentBody;
import com.example.hospital_managemant.DRO.PatientQueryBody;
import com.example.hospital_managemant.entity.Appointment;
import com.example.hospital_managemant.entity.Patient;
import com.example.hospital_managemant.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/patients")
@RestController
@CrossOrigin("http://localhost:3000")

public class PatientController {
    @Autowired
    private PatientService patientService;
    @PostMapping("/add-query")
    public ResponseEntity<?> addQuery(@RequestBody PatientQueryBody patientQueryBody){
        boolean b = patientService.addQuery(patientQueryBody);
        if(b)
            return ResponseEntity.ok("Query registered");
        else return ResponseEntity.badRequest().body("not able to query try after some time");
    }
    @PostMapping("/register")
    public ResponseEntity<String> registerPatient(@RequestBody Patient patient) {

        patientService.registerPatient(patient);
        return ResponseEntity.ok("Patient registered successfully");
    }


//    @GetMapping("/appointments/book")
//    public ResponseEntity<?>  bookAppointment(@RequestBody BookAppointmentBody bookAppointmentBody){
//        boolean b=patientService.bookAppointment(bookAppointmentBody);
//        if(b) return ResponseEntity.ok("requested appointment");
//        else return ResponseEntity.badRequest().body("not able to book");
//    }

    @PostMapping("appointments")

    public ResponseEntity<?> bookAppointment(@RequestBody BookAppointmentBody appointment) {
//        return patientService.bookAppointment(patientId, appointment);
//        boolean b = patientService.bookAppointment(appointment);
//        if (b)
//            return ResponseEntity.ok(appointment);
//        return ResponseEntity.badRequest().body("already requested appointment");
        System.out.println("reached book Appointment");
        return patientService.bookAppointment(appointment);
    }

@GetMapping("see/appointments/{id}")
    public List<Appointment> getAppointment(@PathVariable Long id){

        return patientService.getAppointment(id);
}
}