package com.Workspace.spring.HospitalManagement.service;

import com.Workspace.spring.HospitalManagement.entity.Patient;
import com.Workspace.spring.HospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service

public class PatientService {

    private final PatientRepository patientRepository;
    private EntityManager entityManager;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Transactional
    public Patient getPatientById(Long id)
    {
       Patient p1= patientRepository.findById(id).orElseThrow();
       Patient p2= patientRepository.findById(id).orElseThrow();
       p1.setName("yoyo");

       return p1;
    }

}
