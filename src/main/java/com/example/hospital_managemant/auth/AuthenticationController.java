package com.example.hospital_managemant.auth;

import com.example.hospital_managemant.entity.Patient;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("patient/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody Patient patient
    ) {
        return ResponseEntity.ok(service.register(patient));
    }
    @PostMapping("patient/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {System.out.println(request);
        return ResponseEntity.ok(service.authenticate(request));
    }



}