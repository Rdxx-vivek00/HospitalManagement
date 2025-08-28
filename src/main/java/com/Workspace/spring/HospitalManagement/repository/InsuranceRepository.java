package com.Workspace.spring.HospitalManagement.repository;

import com.Workspace.spring.HospitalManagement.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}