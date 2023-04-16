package com.example.hospital_managemant.entity;

import com.example.hospital_managemant.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;



@Data
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
public class Patient implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name is required")

    private String firstName;

    @NotBlank(message = "Last name is required")

    private String lastName;
    @Column(unique = true)
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email")
    private String email;

    private LocalDateTime registrationDate;

    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "Phone number is required")

    private String phoneNumber;

    @NotBlank(message = "Address is required")
    private String address;

    @Enumerated(EnumType.STRING)
    private Role role;

    public Long getId() {
        return id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    //    @OneToMany(mappedBy = "patient")
//    private List<Appointment> appointments;
//
//    @OneToMany(mappedBy = "patient")
//    private List<Query> queries;



    // getters and setters
}
