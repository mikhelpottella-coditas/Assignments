package com.assignment.week8assignment.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class Task {

//    ● id
//● employeeName
//● employeeEmail
//● taskTitle
//● taskDescription
//● priority (LOW / MEDIUM / HIGH)
//● status (ASSIGNED / IN_PROGRESS / COMPLETED)
//● createdDate
//● updatedDate

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String employeeName;
    @Column(nullable = false, unique = true)
    String employeeEmail;
    @Column(nullable = false)
    String taskTitle;
    @Column(nullable = false)
    String taskDescription;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    Priority priority;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    Status status;

    LocalDateTime createdDate;

    LocalDateTime updatedDate;


    @PrePersist
    public void prePersist() {
        createdDate = LocalDateTime.now();
        status = Status.ASSIGNED;
    }

    @PreUpdate
    public void preUpdate() {
        updatedDate = LocalDateTime.now();
    }
}


