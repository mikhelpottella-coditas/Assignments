package com.assignment.week9assignment.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sessionName;

    private String agenda;

    private Long attendance;

    @ManyToMany
    @JsonIgnoreProperties("sessionList")
    private List<Candidate> candidateList;

    @ManyToOne(cascade = CascadeType.ALL)
    private Conference conference;


}
