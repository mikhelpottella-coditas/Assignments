package com.learning.week6assignment.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDto{

    private Integer id;

    @NotBlank
    private String firstName;
    private String lastName;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String department;


    @Positive
    private Double salary;

    public EmployeeDto() {
    }

    public EmployeeDto(Integer id, String firstName, String lastName, String email, String department, Double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.department = department;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }

    public Double getSalary() {
        return salary;
    }
};
