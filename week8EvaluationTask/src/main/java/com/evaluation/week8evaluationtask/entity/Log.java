package com.evaluation.week8evaluationtask.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
public class Log {

    @Id
    @GeneratedValue
    private Long id;

    private String methodName;

    private String arguments;

    private String status;

    private String message;

}
