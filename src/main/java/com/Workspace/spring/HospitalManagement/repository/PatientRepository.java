package com.Workspace.spring.HospitalManagement.repository;

import com.Workspace.spring.HospitalManagement.entity.Patient;
import com.Workspace.spring.HospitalManagement.entity.type.BloodGroupType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {


    Patient findByName(String name);


    @Query("SELECT p from Patient p where p.bloodGroup=?1")
    List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroup);
}