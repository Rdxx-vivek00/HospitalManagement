package com.Workspace.spring.HospitalManagement.repository;

import com.Workspace.spring.HospitalManagement.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}