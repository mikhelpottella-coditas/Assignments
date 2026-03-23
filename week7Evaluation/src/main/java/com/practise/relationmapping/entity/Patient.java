package com.practise.relationmapping.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public abstract class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private PatientType patientType;


    @ManyToOne
    @JoinColumn(name = "doctor_id")
    @JsonIgnoreProperties("patient")
    Doctor doctor;

    @OneToMany(mappedBy = "patient")
    @JsonIgnoreProperties("patient")
    List<Prescription> prescription;

    public abstract double calculateBill();

}

