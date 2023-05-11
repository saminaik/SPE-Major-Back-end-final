package com.example.hospital_managemant.controller;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.hospital_managemant.entity.Doctor;
import com.example.hospital_managemant.entity.Patient;
import com.example.hospital_managemant.entity.Query;
import com.example.hospital_managemant.repository.AppointmentRepository;
import com.example.hospital_managemant.repository.DoctorRepository;
import com.example.hospital_managemant.repository.PatientRepository;
import com.example.hospital_managemant.repository.PrescriptionRepository;
import com.example.hospital_managemant.repository.QueryRepository;
import com.example.hospital_managemant.repository.TreatmentRepository;
import com.example.hospital_managemant.serviceImp.AdminServiceImp;
import com.example.hospital_managemant.serviceImp.DoctorServiceImpl;
import com.example.hospital_managemant.serviceImp.PatientServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Md4PasswordEncoder;

class AdminControllerTest {
    /**
     * Method under test: {@link AdminController#getquery()}
     */
    @Test
    void testGetquery() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Diffblue AI was unable to find a test

        QueryRepository queryRepository = mock(QueryRepository.class);
        ArrayList<Query> queryList = new ArrayList<>();
        when(queryRepository.findByStatus((String) any())).thenReturn(queryList);
        AdminServiceImp adminService = new AdminServiceImp(queryRepository);
        DoctorRepository doctorRepository = mock(DoctorRepository.class);
        AppointmentRepository appointmentRepository = mock(AppointmentRepository.class);
        DoctorServiceImpl doctorService = new DoctorServiceImpl(doctorRepository, appointmentRepository,
                new BCryptPasswordEncoder(), mock(TreatmentRepository.class), mock(PrescriptionRepository.class));

        List<Query> actualGetqueryResult = (new AdminController(doctorService, adminService,
                new PatientServiceImpl(mock(PatientRepository.class), mock(AppointmentRepository.class),
                        mock(QueryRepository.class), mock(DoctorRepository.class), mock(PrescriptionRepository.class),
                        mock(TreatmentRepository.class)))).getquery();
        assertSame(queryList, actualGetqueryResult);
        assertTrue(actualGetqueryResult.isEmpty());
        verify(queryRepository).findByStatus((String) any());
    }

    /**
     * Method under test: {@link AdminController#addDoctor(Doctor)}
     */
    @Test
    void testAddDoctor() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   jakarta.servlet.ServletException: Request processing failed: org.springframework.http.converter.HttpMessageConversionException: Type definition error: [simple type, class org.springframework.security.core.GrantedAuthority]
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:563)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:631)
        //   org.springframework.http.converter.HttpMessageConversionException: Type definition error: [simple type, class org.springframework.security.core.GrantedAuthority]
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:563)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:631)
        //   com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Cannot construct instance of `org.springframework.security.core.GrantedAuthority` (no Creators, like default constructor, exist): abstract types either need to be mapped to concrete types, have custom deserializer, or contain additional type information
        //    at [Source: (org.springframework.util.StreamUtils$NonClosingInputStream); line: 1, column: 270] (through reference chain: com.example.hospital_managemant.entity.Doctor["authorities"]->java.util.ImmutableCollections$List12[1])
        //       at com.fasterxml.jackson.databind.exc.InvalidDefinitionException.from(InvalidDefinitionException.java:67)
        //       at com.fasterxml.jackson.databind.DeserializationContext.reportBadDefinition(DeserializationContext.java:1909)
        //       at com.fasterxml.jackson.databind.DatabindContext.reportBadDefinition(DatabindContext.java:408)
        //       at com.fasterxml.jackson.databind.DeserializationContext.handleMissingInstantiator(DeserializationContext.java:1354)
        //       at com.fasterxml.jackson.databind.deser.AbstractDeserializer.deserialize(AbstractDeserializer.java:274)
        //       at com.fasterxml.jackson.databind.deser.std.CollectionDeserializer._deserializeFromArray(CollectionDeserializer.java:359)
        //       at com.fasterxml.jackson.databind.deser.std.CollectionDeserializer.deserialize(CollectionDeserializer.java:272)
        //       at com.fasterxml.jackson.databind.deser.std.CollectionDeserializer.deserialize(CollectionDeserializer.java:28)
        //       at com.fasterxml.jackson.databind.deser.impl.SetterlessProperty.deserializeAndSet(SetterlessProperty.java:134)
        //       at com.fasterxml.jackson.databind.deser.BeanDeserializer.deserializeFromObject(BeanDeserializer.java:392)
        //       at com.fasterxml.jackson.databind.deser.BeanDeserializer.deserialize(BeanDeserializer.java:185)
        //       at com.fasterxml.jackson.databind.deser.DefaultDeserializationContext.readRootValue(DefaultDeserializationContext.java:323)
        //       at com.fasterxml.jackson.databind.ObjectReader._bindAndClose(ObjectReader.java:2105)
        //       at com.fasterxml.jackson.databind.ObjectReader.readValue(ObjectReader.java:1481)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:563)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:631)
        //   See https://diff.blue/R013 to resolve this issue.

        DoctorRepository doctorRepository = mock(DoctorRepository.class);
        when(doctorRepository.save((Doctor) any())).thenReturn(new Doctor("Name", "Timing", "Specialization"));
        AppointmentRepository appointmentRepository = mock(AppointmentRepository.class);
        DoctorServiceImpl doctorService = new DoctorServiceImpl(doctorRepository, appointmentRepository,
                new Md4PasswordEncoder(), mock(TreatmentRepository.class), mock(PrescriptionRepository.class));

        AdminServiceImp adminService = new AdminServiceImp(mock(QueryRepository.class));
        AdminController adminController = new AdminController(doctorService, adminService,
                new PatientServiceImpl(mock(PatientRepository.class), mock(AppointmentRepository.class),
                        mock(QueryRepository.class), mock(DoctorRepository.class), mock(PrescriptionRepository.class),
                        mock(TreatmentRepository.class)));
        adminController.addDoctor(new Doctor("Name", "Timing", "Specialization"));
        verify(doctorRepository).save((Doctor) any());
    }

    /**
     * Method under test: {@link AdminController#deleteDoctor(Long)}
     */
    @Test
    void testDeleteDoctor() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Diffblue AI was unable to find a test

        DoctorRepository doctorRepository = mock(DoctorRepository.class);
        doNothing().when(doctorRepository).deleteById((Long) any());
        when(doctorRepository.findById((Long) any()))
                .thenReturn(Optional.of(new Doctor("Name", "Timing", "Specialization")));
        AppointmentRepository appointmentRepository = mock(AppointmentRepository.class);
        DoctorServiceImpl doctorService = new DoctorServiceImpl(doctorRepository, appointmentRepository,
                new BCryptPasswordEncoder(), mock(TreatmentRepository.class), mock(PrescriptionRepository.class));

        AdminServiceImp adminService = new AdminServiceImp(mock(QueryRepository.class));
        (new AdminController(doctorService, adminService,
                new PatientServiceImpl(mock(PatientRepository.class), mock(AppointmentRepository.class),
                        mock(QueryRepository.class), mock(DoctorRepository.class), mock(PrescriptionRepository.class),
                        mock(TreatmentRepository.class)))).deleteDoctor(1L);
        verify(doctorRepository).findById((Long) any());
        verify(doctorRepository).deleteById((Long) any());
    }

    /**
     * Method under test: {@link AdminController#getAllDoctors()}
     */
    @Test
    void testGetAllDoctors() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Diffblue AI was unable to find a test

        DoctorRepository doctorRepository = mock(DoctorRepository.class);
        ArrayList<Doctor> doctorList = new ArrayList<>();
        when(doctorRepository.findAll()).thenReturn(doctorList);
        AppointmentRepository appointmentRepository = mock(AppointmentRepository.class);
        DoctorServiceImpl doctorService = new DoctorServiceImpl(doctorRepository, appointmentRepository,
                new BCryptPasswordEncoder(), mock(TreatmentRepository.class), mock(PrescriptionRepository.class));

        AdminServiceImp adminService = new AdminServiceImp(mock(QueryRepository.class));
        List<Doctor> actualAllDoctors = (new AdminController(doctorService, adminService,
                new PatientServiceImpl(mock(PatientRepository.class), mock(AppointmentRepository.class),
                        mock(QueryRepository.class), mock(DoctorRepository.class), mock(PrescriptionRepository.class),
                        mock(TreatmentRepository.class)))).getAllDoctors();
        assertSame(doctorList, actualAllDoctors);
        assertTrue(actualAllDoctors.isEmpty());
        verify(doctorRepository).findAll();
    }

    /**
     * Method under test: {@link AdminController#getAllPatients()}
     */
    @Test
    void testGetAllPatients() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Diffblue AI was unable to find a test

        PatientRepository patientRepository = mock(PatientRepository.class);
        ArrayList<Patient> patientList = new ArrayList<>();
        when(patientRepository.findAll()).thenReturn(patientList);
        PatientServiceImpl patientService = new PatientServiceImpl(patientRepository, mock(AppointmentRepository.class),
                mock(QueryRepository.class), mock(DoctorRepository.class), mock(PrescriptionRepository.class),
                mock(TreatmentRepository.class));

        DoctorRepository doctorRepository = mock(DoctorRepository.class);
        AppointmentRepository appointmentRepository = mock(AppointmentRepository.class);
        DoctorServiceImpl doctorService = new DoctorServiceImpl(doctorRepository, appointmentRepository,
                new BCryptPasswordEncoder(), mock(TreatmentRepository.class), mock(PrescriptionRepository.class));

        List<Patient> actualAllPatients = (new AdminController(doctorService,
                new AdminServiceImp(mock(QueryRepository.class)), patientService)).getAllPatients();
        assertSame(patientList, actualAllPatients);
        assertTrue(actualAllPatients.isEmpty());
        verify(patientRepository).findAll();
    }
}

