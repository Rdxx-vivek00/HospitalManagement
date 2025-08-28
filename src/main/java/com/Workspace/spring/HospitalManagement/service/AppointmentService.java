package com.Workspace.spring.HospitalManagement.service;

import com.Workspace.spring.HospitalManagement.entity.Appointment;
import com.Workspace.spring.HospitalManagement.entity.Doctor;
import com.Workspace.spring.HospitalManagement.entity.Patient;
import com.Workspace.spring.HospitalManagement.repository.AppointmentRepository;
import com.Workspace.spring.HospitalManagement.repository.DoctorRepository;
import com.Workspace.spring.HospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private  final PatientRepository patientRepository;

    @Transactional
    public Appointment createAppointment(Appointment appointment,Long doctor_id,Long patient_id)
    {
        Doctor doctor=doctorRepository.findById(doctor_id).orElseThrow();
        Patient patient=patientRepository.findById(patient_id).orElseThrow();

        if(appointment.getPatient()!=null)
        {
            throw new IllegalArgumentException("Appointment should not have ");
        }

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        patient.getAppointments().add(appointment);

      return  appointmentRepository.save(appointment);
    }

    @Transactional
    public Appointment reassignAppointmentToAnewDoctor(Long appointmentId,Long doctorId)
    {
        Appointment appointment=appointmentRepository.findById(appointmentId).orElseThrow();

        Doctor doctor=doctorRepository.findById(doctorId).orElseThrow();

        appointment.setDoctor(doctor);
        doctor.getAppointments().add(appointment);

        return appointment;
    }
}
