package com.practise.relationmapping.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public abstract class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private PatientType patientType;


    @ManyToOne
    @JoinColumn(name = "doctor_id")
    Doctor doctor;

    @OneToMany(mappedBy = "patient")
    List<Prescription> prescription;

    public abstract double calculateBill();

}

