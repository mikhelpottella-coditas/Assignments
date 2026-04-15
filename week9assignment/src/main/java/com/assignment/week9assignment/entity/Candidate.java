package com.assignment.week9assignment.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Candidate {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("")
    private User user;


    @ManyToMany(mappedBy = "candidateList")
    @JsonIgnoreProperties("candidateList")
    private List<Session> sessionList;





}
