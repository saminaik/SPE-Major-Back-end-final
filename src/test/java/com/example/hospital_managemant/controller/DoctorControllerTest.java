package com.example.hospital_managemant.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.hospital_managemant.entity.Appointment;
import com.example.hospital_managemant.entity.Prescription;
import com.example.hospital_managemant.entity.Treatement;
import com.example.hospital_managemant.enums.AppointmentStatus;
import com.example.hospital_managemant.repository.AppointmentRepository;
import com.example.hospital_managemant.repository.DoctorRepository;
import com.example.hospital_managemant.repository.PrescriptionRepository;
import com.example.hospital_managemant.repository.TreatmentRepository;
import com.example.hospital_managemant.service.DoctorService;
import com.example.hospital_managemant.serviceImp.DoctorServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

class DoctorControllerTest {
    /**
     * Method under test: {@link DoctorController#getAllAppointments(Long)}
     */
    @Test
    void testGetAllAppointments() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Diffblue AI was unable to find a test

        AppointmentRepository appointmentRepository = mock(AppointmentRepository.class);
        when(appointmentRepository.findByDoctor_Id((Long) any())).thenReturn(new ArrayList<>());
        DoctorRepository doctorRepository = mock(DoctorRepository.class);
        assertNull((new DoctorController(new DoctorServiceImpl(doctorRepository, appointmentRepository,
                new BCryptPasswordEncoder(), mock(TreatmentRepository.class), mock(PrescriptionRepository.class))))
                .getAllAppointments(1L));
        verify(appointmentRepository).findByDoctor_Id((Long) any());
    }

    /**
     * Method under test: {@link DoctorController#getAllAppointments(Long)}
     */
    @Test
    void testGetAllAppointments2() {


        ArrayList<Appointment> appointmentList = new ArrayList<>();
        appointmentList.add(new Appointment("2020-03-01", AppointmentStatus.REQUESTED));
        AppointmentRepository appointmentRepository = mock(AppointmentRepository.class);
        when(appointmentRepository.findByDoctor_Id((Long) any())).thenReturn(appointmentList);
        DoctorRepository doctorRepository = mock(DoctorRepository.class);
        List<Appointment> actualAllAppointments = (new DoctorController(
                new DoctorServiceImpl(doctorRepository, appointmentRepository, new BCryptPasswordEncoder(),
                        mock(TreatmentRepository.class), mock(PrescriptionRepository.class)))).getAllAppointments(1L);
        assertSame(appointmentList, actualAllAppointments);
        assertEquals(1, actualAllAppointments.size());
        verify(appointmentRepository).findByDoctor_Id((Long) any());
    }

    /**
     * Method under test: {@link DoctorController#setTreatment(Treatement)}
     */
    @Test
    void testSetTreatment() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R034 Diffblue Cover can't complete test.
        //   Diffblue Cover was unable to complete the test.
        //   Try to increase the number of fuzzing iterations if non-default
        //   value is used.
        //   See https://diff.blue/R034 for further troubleshooting of this issue.

        TreatmentRepository treatmentRepository = mock(TreatmentRepository.class);
        when(treatmentRepository.save((Treatement) any())).thenReturn(new Treatement());
        DoctorRepository doctorRepository = mock(DoctorRepository.class);
        AppointmentRepository appointmentRepository = mock(AppointmentRepository.class);
        DoctorController doctorController = new DoctorController(new DoctorServiceImpl(doctorRepository,
                appointmentRepository, new BCryptPasswordEncoder(), treatmentRepository, mock(PrescriptionRepository.class)));
        ResponseEntity<?> actualSetTreatmentResult = doctorController.setTreatment(new Treatement());
        assertTrue(actualSetTreatmentResult.hasBody());
        assertEquals(200, actualSetTreatmentResult.getStatusCodeValue());
        assertTrue(actualSetTreatmentResult.getHeaders().isEmpty());
        verify(treatmentRepository).save((Treatement) any());
    }

    /**
     * Method under test: {@link DoctorController#setPrescription(Prescription)}
     */
    @Test
    void testSetPrescription() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R034 Diffblue Cover can't complete test.
        //   Diffblue Cover was unable to complete the test.
        //   Try to increase the number of fuzzing iterations if non-default
        //   value is used.
        //   See https://diff.blue/R034 for further troubleshooting of this issue.

        PrescriptionRepository prescriptionRepository = mock(PrescriptionRepository.class);
        when(prescriptionRepository.save((Prescription) any())).thenReturn(new Prescription());
        DoctorRepository doctorRepository = mock(DoctorRepository.class);
        AppointmentRepository appointmentRepository = mock(AppointmentRepository.class);
        DoctorController doctorController = new DoctorController(new DoctorServiceImpl(doctorRepository,
                appointmentRepository, new BCryptPasswordEncoder(), mock(TreatmentRepository.class), prescriptionRepository));
        ResponseEntity<?> actualSetPrescriptionResult = doctorController.setPrescription(new Prescription());
        assertTrue(actualSetPrescriptionResult.hasBody());
        assertEquals(200, actualSetPrescriptionResult.getStatusCodeValue());
        assertTrue(actualSetPrescriptionResult.getHeaders().isEmpty());
        verify(prescriptionRepository).save((Prescription) any());
    }

    /**
     * Method under test: {@link DoctorController#approveAppoinment(Long, String)}
     */
    @Test
    void testApproveAppoinment() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.test.web.servlet.RequestBuilder.buildRequest(jakarta.servlet.ServletContext)" because "requestBuilder" is null
        //   See https://diff.blue/R013 to resolve this issue.

        DoctorService doctorService = mock(DoctorService.class);
        when((ResponseEntity<Object>) doctorService.approveAppoinment((Long) any(), (String) any())).thenReturn(null);
        assertNull((new DoctorController(doctorService)).approveAppoinment(1L, "ISAPPROVED"));
        verify(doctorService).approveAppoinment((Long) any(), (String) any());
    }
}

