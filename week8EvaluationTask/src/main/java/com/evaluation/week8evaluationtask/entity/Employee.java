package com.evaluation.week8evaluationtask.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
public class Employee {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private UserAuth userAuth;

    @OneToMany(mappedBy = "employee")
    @JsonIgnoreProperties("employee")
    private List<Task> task;

}
