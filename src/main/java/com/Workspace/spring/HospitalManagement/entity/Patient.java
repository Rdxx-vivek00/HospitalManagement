package com.Workspace.spring.HospitalManagement.entity;

import com.Workspace.spring.HospitalManagement.entity.type.BloodGroupType;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name="Patient")
@Table(
        name = "patient",
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

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;

    @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JoinColumn(name = "patient_insurance_id")
    private Insurance insurance;


}
