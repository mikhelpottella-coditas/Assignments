package com.evaluation.week8evaluationtask.dto;

import lombok.Data;

@Data
public class CreateTaskDto {

    private String title;
    private String description;
    private String status;
    private String priority;
    private Long employeeId;

}
