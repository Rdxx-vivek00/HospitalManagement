package com.Workspace.spring.HospitalManagement.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 100,unique = true)
    private String name;


    @OneToOne
    @JoinColumn
    private Doctor headDoctor;

    @ManyToMany
    @JoinTable(
            name = "my_dept_doct",
            joinColumns = @JoinColumn(name = "dpt_id"),
            inverseJoinColumns = @JoinColumn(name="dept_id")
    )
    private Set<Doctor> doctors=new HashSet<>();
}
