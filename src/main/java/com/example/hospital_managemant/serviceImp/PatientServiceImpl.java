package com.example.hospital_managemant.serviceImp;

import com.example.hospital_managemant.DRO.BookAppointmentBody;
import com.example.hospital_managemant.DRO.PatientQueryBody;
import com.example.hospital_managemant.entity.*;
import com.example.hospital_managemant.enums.AppointmentStatus;
import com.example.hospital_managemant.repository.*;
import com.example.hospital_managemant.service.PatientService;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
    private final PrescriptionRepository prescriptionRepository;
    private final TreatmentRepository treatmentRepository;

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }



    public PatientServiceImpl(PatientRepository patientRepository, AppointmentRepository appointmentRepository, QueryRepository queryRepository,
                              DoctorRepository doctorRepository,
                              PrescriptionRepository prescriptionRepository,
                              TreatmentRepository treatmentRepository) {
        this.patientRepository = patientRepository;
        this.appointmentRepository = appointmentRepository;
        this.queryRepository = queryRepository;
        this.doctorRepository = doctorRepository;
        this.prescriptionRepository = prescriptionRepository;
        this.treatmentRepository = treatmentRepository;
    }






    @Override
    public Patient  registerPatient(Patient patient) {
        // Set registration date
        patient.setRegistrationDate(LocalDateTime.now());
     try{
     return    patientRepository.save(patient);


     }
     catch (DataIntegrityViolationException e)
     {
         System.out.println(e.getMessage());
         throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already exists", e);
     }
    }

    @Override
    public boolean addQuery(PatientQueryBody patientQueryBody) {
        try {
            System.out.println(patientQueryBody.getPatinet_id());
            Patient patient = patientRepository.findById(patientQueryBody.getPatinet_id()).get();
            Query query = new Query("requested",patientQueryBody.getSubject(),
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
           appointment.setPatient_name(patient.getFirstName());
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



    @Override
    public List<Prescription> getPrescription(Long id) {
        return prescriptionRepository.findByAppointmentId(id);
    }

    @Override
    public List<Appointment> getApproved(Long id) {
        AppointmentStatus status = AppointmentStatus.valueOf("APPROVED");
        return  appointmentRepository.findByPatient_IdAndStatus(id,status);
    }

    @Override
    public List<Treatement> getTreatment(Long id) {
        return treatmentRepository.findByAppointmentId(id);
    }

    @Override
    public List<Query> getQuir(Long id) {
        return queryRepository.findByPatient_Id(id);
    }


}
