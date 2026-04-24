package com.assignment.week9assignment.entity;

import com.assignment.week9assignment.enums.ConferenceType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Conference {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String conferenceName;

    @Enumerated(EnumType.STRING)
    private ConferenceType conferenceType;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "conference",orphanRemoval = true)
    @JsonIgnoreProperties("conference")
    private List<Session> sessions;


    public void addSession(Session session){
        if(sessions==null) sessions=new ArrayList<>();
        sessions.add(session);
        session.setConference(this);
    }

}
