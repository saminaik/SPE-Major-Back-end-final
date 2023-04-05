package com.example.hospital_managemant.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;



@Data
@NoArgsConstructor

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name is required")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email")
    private String email;
    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "Phone number is required")
    @Column(name = "phone_number")
    private String phoneNumber;

    @NotBlank(message = "Address is required")
    private String address;

    public Patient(String firstName, String lastName, String email, LocalDateTime registrationDate, String password, String phoneNumber, String address) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.registrationDate = registrationDate;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    //    @OneToMany(mappedBy = "patient")
//    private List<Appointment> appointments;
//
//    @OneToMany(mappedBy = "patient")
//    private List<Query> queries;



    // getters and setters
}
