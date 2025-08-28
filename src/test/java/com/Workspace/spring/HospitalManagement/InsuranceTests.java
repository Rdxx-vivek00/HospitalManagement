package com.Workspace.spring.HospitalManagement;

import com.Workspace.spring.HospitalManagement.entity.Appointment;
import com.Workspace.spring.HospitalManagement.entity.Insurance;
import com.Workspace.spring.HospitalManagement.entity.Patient;
import com.Workspace.spring.HospitalManagement.service.AppointmentService;
import com.Workspace.spring.HospitalManagement.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTests {

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testInsurance()
    {
        Insurance insurance=Insurance.builder()
                .policyNumber("HDFC_1234")
                .provider("HDFC")
                .validUntil(LocalDate.of(2030,12,12))
                .build();

        Patient patient=insuranceService.assignInsuranceToPatient(insurance,2L);

        System.out.println(patient);

        var newPatient=insuranceService.disassociateInsuranceFromPatient(patient.getId());
        System.out.println(newPatient);

    }
    @Test
    public void testCreateAppointment()
    {
        Appointment appointment=Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025,11,1,14,0))
                .reason("dengue")
                .build();

       var newAppointment= appointmentService.createAppointment(appointment,1L,2L);

        System.out.println(newAppointment);

      var updatedAppointment= appointmentService.reassignAppointmentToAnewDoctor(newAppointment.getId(), 3L);

        System.out.println(updatedAppointment);



    }

}
