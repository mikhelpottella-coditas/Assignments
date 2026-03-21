package com.practise.relationmapping.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Doctor {

    @Id
    @GeneratedValue
    Long id;

    @Column(nullable = false)
    @NotBlank
    String name;


    @OneToMany(mappedBy = "doctor")
    @JsonIgnoreProperties("doctor")
    private List<Patient> patients;

    @OneToMany(mappedBy = "doctor")
    @JsonIgnoreProperties("doctor")
    private List<Prescription> prescriptions;

    public Doctor() {}

}
