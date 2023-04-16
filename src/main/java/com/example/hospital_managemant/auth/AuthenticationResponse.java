package com.example.hospital_managemant.auth;

import com.example.hospital_managemant.entity.Patient;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

   private String token;
   private String username;
   private String role;
   private Integer id;
//   private Patient patient;
}

