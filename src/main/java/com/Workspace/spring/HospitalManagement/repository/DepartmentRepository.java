package com.Workspace.spring.HospitalManagement.repository;

import com.Workspace.spring.HospitalManagement.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}