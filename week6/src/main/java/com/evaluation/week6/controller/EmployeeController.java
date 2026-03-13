package com.evaluation.week6.controller;

import com.evaluation.week6.dto.EmployeeResponceDto;
import com.evaluation.week6.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private  EmployeeService employeeService;

//    public EmployeeController(EmployeeService employeeService) {
//        this.employeeService = employeeService;
//    }
    //    Retrieve all employees

    @GetMapping("/all")
    public List<EmployeeResponceDto> getAll() {
        return employeeService.getAll();
    }


//Retrieve an employee by id
    @GetMapping("/byid/{id}")
    public EmployeeResponceDto getById(@PathVariable int id) {
        return employeeService.getById(id);
    }

//Add a new employee
    @PostMapping("/addemp")
    public String addEmployee(@RequestBody EmployeeResponceDto employee) {
        return employeeService.addEmployee(employee);
    }
//Update an existing employee
    @PatchMapping("/update/{id}")
    public String updateEmployee(@PathVariable int id, @RequestBody EmployeeResponceDto employee) {
        return  employeeService.updateEmployee(id,employee);
    }
//Delete an employee by id
    @DeleteMapping("/deleteemp/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return  employeeService.deleteEmployee(id);
    }


//Retrieve the top 3 highest-paid employees
    @GetMapping("/top3")
    public List<EmployeeResponceDto> getTop3() {
        return employeeService.top3();
    }
}
