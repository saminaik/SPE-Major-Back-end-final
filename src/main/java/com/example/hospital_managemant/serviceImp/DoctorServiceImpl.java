package com.example.hospital_managemant.serviceImp;


import com.example.hospital_managemant.entity.Appointment;
import com.example.hospital_managemant.entity.Doctor;
import com.example.hospital_managemant.entity.Prescription;
import com.example.hospital_managemant.entity.Treatement;
import com.example.hospital_managemant.enums.AppointmentStatus;
import com.example.hospital_managemant.repository.AppointmentRepository;
import com.example.hospital_managemant.repository.DoctorRepository;
import com.example.hospital_managemant.repository.PrescriptionRepository;
import com.example.hospital_managemant.repository.TreatmentRepository;
import com.example.hospital_managemant.service.DoctorService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
  public class DoctorServiceImpl implements DoctorService {
    private final PasswordEncoder passwordEncoder;
    private final DoctorRepository doctorRepository;
    private final AppointmentRepository appointmentRepository;
    private final TreatmentRepository treatmentRepository;
    private final PrescriptionRepository prescriptionRepository;


    public DoctorServiceImpl(DoctorRepository doctorRepository,
                             AppointmentRepository appointmentRepository,PasswordEncoder passwordEncoder,
                             TreatmentRepository treatmentRepository,
                             PrescriptionRepository prescriptionRepository) {
        this.doctorRepository = doctorRepository;
        this.appointmentRepository = appointmentRepository;
        this.passwordEncoder=passwordEncoder;
        this.treatmentRepository = treatmentRepository;
        this.prescriptionRepository = prescriptionRepository;
    }
    @Override
    public void addDoctor(Doctor doctor) {
        doctor.setPassword(passwordEncoder.encode(doctor.getPassword()));
         doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }

    @Override
    public List<Appointment> getAllAppointments(Long id) {
        try{
//            appointmentRepository.findAll();

            return appointmentRepository.findByDoctor_Id(id);
        }catch (Exception e){
            System.out.println(e.getMessage());

        }
        return null;
    }

    @Override
    public ResponseEntity<?> setTreatment(Treatement treat) {

        Treatement t=treatmentRepository.save(treat);
        return ResponseEntity.ok(t);
    }

    @Override
    public ResponseEntity<?> setPriscription(Prescription prescription) {
        System.out.println(prescription);
        Prescription p=prescriptionRepository.save(prescription);
        System.out.println(p);

        return ResponseEntity.ok(p);
    }

    @Override
    public ResponseEntity<?> approveAppoinment(Long id, String str) {
        AppointmentStatus ap = AppointmentStatus.valueOf(str);

        appointmentRepository.updateStatusById(ap,id);
    return ResponseEntity.ok(str);
    }


//    @Override
//    public boolean approveAppointmentsById(Long id, String status) {
//       try
//        {
//            appointmentRepository.updateStatusById(AppointmentStatus.valueOf(status),id);
//        }
//        catch (Exception e){
//            System.out.println(e);
//        }
//        return false;
//    }



    @Override
    public void deleteDoctorById(Long id) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(id);
        if (optionalDoctor.isPresent()) {
            doctorRepository.deleteById(id);

        } else {
            throw new RuntimeException("Doctor not found with ID: " + id);
        }
    }



}