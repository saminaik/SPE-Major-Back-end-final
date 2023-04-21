package com.example.hospital_managemant.serviceImp;

import com.example.hospital_managemant.DRO.BookAppointmentBody;
import com.example.hospital_managemant.DRO.PatientQueryBody;
import com.example.hospital_managemant.entity.Appointment;
import com.example.hospital_managemant.entity.Doctor;
import com.example.hospital_managemant.entity.Patient;
import com.example.hospital_managemant.entity.Query;
import com.example.hospital_managemant.enums.AppointmentStatus;
import com.example.hospital_managemant.repository.AppointmentRepository;
import com.example.hospital_managemant.repository.DoctorRepository;
import com.example.hospital_managemant.repository.PatientRepository;
import com.example.hospital_managemant.repository.QueryRepository;
import com.example.hospital_managemant.service.PatientService;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final AppointmentRepository appointmentRepository;

    private final QueryRepository queryRepository;
    private final DoctorRepository doctorRepository;

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }



    public PatientServiceImpl(PatientRepository patientRepository, AppointmentRepository appointmentRepository, QueryRepository queryRepository,
                              DoctorRepository doctorRepository) {
        this.patientRepository = patientRepository;
        this.appointmentRepository = appointmentRepository;
        this.queryRepository = queryRepository;
        this.doctorRepository = doctorRepository;
    }






    @Override
    public void registerPatient(Patient patient) {
        // Set registration date
        patient.setRegistrationDate(LocalDateTime.now());

        // Save patient to database
        patientRepository.save(patient);
    }

//asking the query



//    @Override
//    public Appointment bookAppointment(Long patientId, Appointment appointment) {
//        // Find patient by ID
//        Patient patient = patientRepository.findById(patientId)
//                .orElseThrow(() -> new ResourceNotFoundException("Patient",
//                        "id",
//                        patientId));
//
//        // Assign patient to appointment
//        appointment.setPatient(patient);
//
//        // Save appointment
//        return appointmentRepository.save(appointment);
//    }

    @Override
    public boolean addQuery(PatientQueryBody patientQueryBody) {
        try {
            System.out.println(patientQueryBody.getPatinet_id());
            Patient patient = patientRepository.findById(patientQueryBody.getPatinet_id()).get();
            Query query = new Query(patientQueryBody.getSubject(),
                    patientQueryBody.getQuery(),
                    "");
            query.setPatient(patient);
            queryRepository.save(query);
            return true;
        }catch (Exception e){
            System.out.println("hello hello hello");
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public ResponseEntity<?> bookAppointment(BookAppointmentBody bookAppointmentBody) {
        try
        {
            System.out.println(bookAppointmentBody);
            Patient patient=patientRepository.findById(bookAppointmentBody.getPatient_id()).get();

            Doctor doctor=doctorRepository.findById(bookAppointmentBody.getDoctorId()).get();

            AppointmentStatus status = AppointmentStatus.REQUESTED;

            Appointment appointment=new Appointment( bookAppointmentBody.getDate(),status);

           appointment.setPatient(patient);
           appointment.setDoctor(doctor);
           appointmentRepository.save(appointment);

           return ResponseEntity.ok("Requested");

        }
        catch (Exception e){
            System.out.println(e);
            return ResponseEntity.badRequest().body("Something went wrong");
        }
//        return false;
    }

    @Override
    public  List<Appointment> getAppointment(Long id) {
       try{

           List<Appointment> byPatient_id = appointmentRepository.findByPatient_Id(id);
           return byPatient_id;


       }
       catch (Exception e){
           System.out.println(e.getMessage());
           return Collections.emptyList();
       }

    }


}
