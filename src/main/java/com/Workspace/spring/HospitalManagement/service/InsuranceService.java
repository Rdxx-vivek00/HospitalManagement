package com.Workspace.spring.HospitalManagement.service;

import com.Workspace.spring.HospitalManagement.entity.Insurance;
import com.Workspace.spring.HospitalManagement.entity.Patient;
import com.Workspace.spring.HospitalManagement.repository.InsuranceRepository;
import com.Workspace.spring.HospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class InsuranceService {

    private  final InsuranceRepository insuranceRepository;
    private  final PatientRepository patientRepository;

    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, Long patient_id)
    {
        Patient patient=patientRepository.findById(patient_id).orElseThrow();

        patient.setInsurance(insurance);

        insurance.setPatient(patient);

        return patient;
    }

    @Transactional
    public Patient disassociateInsuranceFromPatient(Long patient_id)
    {
        Patient patient=patientRepository.findById(patient_id).orElseThrow();
         patient.setInsurance(null);

         return patient;
    }


}
