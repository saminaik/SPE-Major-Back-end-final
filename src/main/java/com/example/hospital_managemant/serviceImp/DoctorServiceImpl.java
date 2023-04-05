package com.example.hospital_managemant.serviceImp;


import com.example.hospital_managemant.entity.Doctor;
import com.example.hospital_managemant.repository.DoctorRepository;
import com.example.hospital_managemant.service.DoctorService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
  public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }
    @Override
    public void addDoctor(Doctor doctor) {
         doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }
    @Override
    public void deleteDoctorById(Long id) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(id);
        if (optionalDoctor.isPresent()) {
            doctorRepository.deleteById(id);

        } else {
            throw new RuntimeException("Doctor not found with ID: " + id);
        }
    }

//    private Doctor getDoctorById(Long id) {
//    return doctorRepository.getReferenceById(id);
//
//    }

}