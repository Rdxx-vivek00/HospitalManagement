package com.Workspace.spring.HospitalManagement.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(
        name = "Patient",
            uniqueConstraints = {  @UniqueConstraint(name = "unique_patient_email",columnNames = {"email"} )}
)
@Builder
public class Patient{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false,length = 40)
    private String name;


    @ToString.Exclude
    private LocalDate birthDate;

     @Column(nullable = false,unique = true)
    private String email;

    private String gender;

    private String bloodGroup;

    public Patient() {
    }

    public Patient(Long id, String name, LocalDate birthDate, String email, String gender, String bloodGroup) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                "bloodGroup='" + bloodGroup + '\'' +
                '}';
    }



}
