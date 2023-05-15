package com.example.hospital_managemant.controller;

import com.example.hospital_managemant.DRO.BookAppointmentBody;
import com.example.hospital_managemant.DRO.PatientQueryBody;
import com.example.hospital_managemant.entity.*;
import com.example.hospital_managemant.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Optional;

@RequestMapping("/api/patients")
@RestController
@CrossOrigin("http://localhost:3000")

public class PatientController {
    private static final Logger logger = LoggerFactory.getLogger(PatientController.class);

    @Autowired
    private PatientService patientService;
    @PostMapping("/add-query")
    public ResponseEntity<?> addQuery(@RequestBody PatientQueryBody patientQueryBody){

       // logger.info("Adding query with patient id {}", patientQueryBody.getPatinet_id());
        long startTime = System.currentTimeMillis();
        boolean b = patientService.addQuery(patientQueryBody);
        long endTime = System.currentTimeMillis(); // record end time
        long requestTime = endTime - startTime; // calculate request time
        if(b){logger.info("API: /add-query, Response state: OK, Request time: " + requestTime + "ms");
            return ResponseEntity.ok("Query registered");
        }
        else {
            logger.info("API:PostMapping /add-query, Response state: OK, Request time: " + requestTime + "ms");
            return ResponseEntity.badRequest().body("not able to query try after some time");}
    }
    @PostMapping("/register")
    public Patient registerPatient(@RequestBody Patient patient) {
        long startTime = System.currentTimeMillis();
        Patient p= patientService.registerPatient(patient);
        long endTime = System.currentTimeMillis(); // record end time
        long requestTime = endTime - startTime; // calculate request time
        logger.info("API: PostMapping /register, Response state: OK, Request time: " + requestTime + "ms");
        return  p;

    }

 @GetMapping("/get/quiries/{id}")
 public List<Query> getQuir(@PathVariable Long id) {
     long startTime = System.currentTimeMillis();
        List<Query> q= patientService.getQuir(id);
     long endTime = System.currentTimeMillis(); // record end time
     long requestTime = endTime - startTime; // calculate request time
     logger.info("API: /get/quiries/id, Response state: OK, Request time: " + requestTime + "ms");
     return q;
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
logger.info("Adding query with patient id ");
        logger.info("Adding query with patient id ");
        logger.info("Adding query with patient id ");
        return patientService.bookAppointment(appointment);
    }

    @GetMapping("getpres/{id}")
    public List<Prescription> getPrescription(@PathVariable Long id){
        long startTime = System.currentTimeMillis();
        List<Prescription> p= patientService.getPrescription(id);
        long endTime = System.currentTimeMillis(); // record end time
        long requestTime = endTime - startTime; // calculate request time
        logger.info("API: see/appointments/approve/id, Response state: OK, Request time: " + requestTime + "ms");

        return p;
    }
    @GetMapping("gettreat/{id}")
    public List<Treatement>getTreatment(@PathVariable Long id){
        long startTime = System.currentTimeMillis();
        List<Treatement> t= patientService.getTreatment(id);
        long endTime = System.currentTimeMillis(); // record end time
        long requestTime = endTime - startTime; // calculate request time
        logger.info("API: see/appointments/approve/id, Response state: OK, Request time: " + requestTime + "ms");

        return t;
    }
@GetMapping("see/appointments/{id}")
    public List<Appointment> getAppointment(@PathVariable Long id){
    long startTime = System.currentTimeMillis(); // record start time
    List<Appointment> p= patientService.getAppointment(id);
    long endTime = System.currentTimeMillis(); // record end time
    long requestTime = endTime - startTime; // calculate request time
    logger.info("API: see/appointments/approve/id, Response state: OK, Request time: " + requestTime + "ms");

    return p;

}
@GetMapping("see/appointments/approve/{id}")
    public List<Appointment> getAppoinments(@PathVariable Long id){

    long startTime = System.currentTimeMillis(); // record start time
    List<Appointment> q= patientService.getApproved(id);
    long endTime = System.currentTimeMillis(); // record end time
    long requestTime = endTime - startTime; // calculate request time
    logger.info("API:GetMapping see/appointments/approve/id, Response state: OK, Request time: " + requestTime + "ms");
        return q;
}

}
