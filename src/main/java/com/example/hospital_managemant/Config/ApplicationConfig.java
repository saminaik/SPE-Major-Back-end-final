package com.example.hospital_managemant.Config;

import com.example.hospital_managemant.repository.AdminRepsitory;
import com.example.hospital_managemant.repository.DoctorRepository;
import com.example.hospital_managemant.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final PatientRepository patientRepository;
    private final AdminRepsitory adminRepsitory;
    private final DoctorRepository doctorRepository;

    @Bean
    public UserDetailsService userDetailsService() {

        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                System.out.println("hello");
                System.out.println(patientRepository.findByEmail(username).isPresent());
                System.out.println("hello");
                if(patientRepository.findByEmail(username).isPresent())
                    return patientRepository.findByEmail(username).orElseThrow();
                else if(doctorRepository.findByEmail(username).isPresent())
                    return doctorRepository.findByEmail(username).orElseThrow();
                else
                    return adminRepsitory.findByEmail(username).orElseThrow();
            }
        };
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}