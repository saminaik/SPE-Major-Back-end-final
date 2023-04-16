package com.example.hospital_managemant.controller;

import com.example.hospital_managemant.entity.Appointment;
import com.example.hospital_managemant.enums.AppointmentStatus;
import com.example.hospital_managemant.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/doctor")
@RestController
public class DoctorController {
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
    @GetMapping("/appointments")
        public List<Appointment> getAllAppointments()
        {
            List<Appointment> appointments = doctorService.getAllAppointments();
            System.out.println(appointments);
            if (appointments.size()==0)
                return null;
            return appointments;
        }

}
