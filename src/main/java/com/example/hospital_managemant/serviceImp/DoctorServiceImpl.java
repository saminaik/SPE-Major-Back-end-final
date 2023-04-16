package com.example.hospital_managemant.serviceImp;


import com.example.hospital_managemant.entity.Appointment;
import com.example.hospital_managemant.entity.Doctor;
import com.example.hospital_managemant.repository.AppointmentRepository;
import com.example.hospital_managemant.repository.DoctorRepository;
import com.example.hospital_managemant.service.DoctorService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
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



    public DoctorServiceImpl(DoctorRepository doctorRepository,
                             AppointmentRepository appointmentRepository,PasswordEncoder passwordEncoder) {
        this.doctorRepository = doctorRepository;
        this.appointmentRepository = appointmentRepository;
        this.passwordEncoder=passwordEncoder;
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
    public List<Appointment> getAllAppointments() {
        try{
//            appointmentRepository.findAll();

            return appointmentRepository.findAll();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
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