package com.example.hospital_managemant.auth;

import com.example.hospital_managemant.Config.JwtService;
import com.example.hospital_managemant.entity.Patient;
import com.example.hospital_managemant.enums.Role;
import com.example.hospital_managemant.repository.AdminRepsitory;
import com.example.hospital_managemant.repository.DoctorRepository;
import com.example.hospital_managemant.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final PatientRepository patientRepository;
    private final AdminRepsitory adminRepsitory;
    private final DoctorRepository doctorRepository;

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(Patient patient) { //request==patient
//        var user = User.builder()
//                .firstname(request.getFirstname())
//                .lastname(request.getLastname())
//                .email(request.getEmail())
//                .password(passwordEncoder.encode(request.getPassword()))
//                .role(Role.USER)
//                .build();
        patient.setPassword(this.passwordEncoder.encode(patient.getPassword()));
        patient.setRole(Role.USER);

        var savedUser = patientRepository.save(patient);
        var jwtToken = jwtService.generateToken(patient);


        return AuthenticationResponse.builder()
                .token(jwtToken)
                .username(savedUser.getUsername())
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = patientRepository.findByEmail(request.getEmail());
        var doctor = doctorRepository.findByEmail(request.getEmail());
        var admin = adminRepsitory.findByEmail(request.getEmail());
        Long id= Long.valueOf(0);

        String jwtToken = "";
        String role = "";
         if (user.isPresent()) {
             id=user.get().getId();
             System.out.println(user.get());
             jwtToken = jwtService.generateToken(user.get());
             role = "PATIENT";
         } else if (doctor.isPresent()) {
             id=doctor.get().getId();
             System.out.println(doctor.get());
             jwtToken = jwtService.generateToken(doctor.get());
             role = "DOCTOR";
         } else if (admin.isPresent()) {
             System.out.println(admin.get());
             id=admin.get().getId();
             jwtToken = jwtService.generateToken(admin.get());
             role = "ADMIN";
         }

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .id(Math.toIntExact(id))
                .username(request.getEmail())
                .role(role)
                .build();
    }

}