package com.example.hospital_managemant.controller;

import com.example.hospital_managemant.DRO.BookAppointmentBody;
import com.example.hospital_managemant.DRO.PatientQueryBody;
import com.example.hospital_managemant.entity.*;
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
    public Patient registerPatient(@RequestBody Patient patient) {

        return patientService.registerPatient(patient);

    }

 @GetMapping("/get/quiries/{id}")
 public List<Query> getQuir(@PathVariable Long id) {
       return patientService.getQuir(id);
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

    @GetMapping("getpres/{id}")
    public List<Prescription> getPrescription(@PathVariable Long id){
        return patientService.getPrescription(id);
    }
    @GetMapping("gettreat/{id}")
    public List<Treatement>getTreatment(@PathVariable Long id){
        return patientService.getTreatment(id);
    }
@GetMapping("see/appointments/{id}")
    public List<Appointment> getAppointment(@PathVariable Long id){

        return patientService.getAppointment(id);
}
@GetMapping("see/appointments/approve/{id}")
    public List<Appointment> getAppoinments(@PathVariable Long id){
        return patientService.getApproved(id);
}

}