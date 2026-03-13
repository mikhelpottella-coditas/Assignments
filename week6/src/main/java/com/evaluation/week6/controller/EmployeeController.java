package com.evaluation.week6.controller;

import com.evaluation.week6.dto.EmployeeResponseDto;
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
    public List<EmployeeResponseDto> getAll() {
        return employeeService.getAll();
    }


//Retrieve an employee by id
    @GetMapping("/byid/{id}")
    public EmployeeResponseDto getById(@PathVariable int id) {
        return employeeService.getById(id);
    }

//Add a new employee
    @PostMapping("/addemp")
    public String addEmployee(@RequestBody EmployeeResponseDto employee) {
        System.out.println(employee);
        return employeeService.addEmployee(employee);
    }
//Update an existing employee
    @PatchMapping("/update/{id}")
    public String updateEmployee(@PathVariable int id, @RequestBody EmployeeResponseDto employee) {
        return  employeeService.updateEmployee(id,employee);
    }
//Delete an employee by id
    @DeleteMapping("/deleteemp/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return  employeeService.deleteEmployee(id);
    }


//Retrieve the top 3 highest-paid employees
    @GetMapping("/top3")
    public List<EmployeeResponseDto> getTop3() {
        return employeeService.top3();
    }
}
