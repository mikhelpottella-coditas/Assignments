package com.assignment.week8assignment.dto;

import com.assignment.week8assignment.entity.Priority;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class TaskRequestDto {

    @NotBlank(message = "must provide employee name")
    private String employeeName;

    @NotBlank(message = "must provide")
    @Email(message = "must provide ID with proper format")
    private String employeeEmail;



    @NotBlank(message = "title of the task is mandatory")
    private String taskTitle;

    private String taskDescription;

    private Priority priority;


}
