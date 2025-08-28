package com.Workspace.spring.HospitalManagement.repository;

import com.Workspace.spring.HospitalManagement.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}