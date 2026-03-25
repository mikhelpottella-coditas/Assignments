package com.learning.week6assignment.controller;

import com.learning.week6assignment.DTO.EmployeeDto;
import com.learning.week6assignment.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }


    @PostMapping("/register")
    public void register(@Valid @RequestBody EmployeeDto employeeDto){

        employeeService.register(employeeDto);

    }

    @GetMapping("/all")
    public List<EmployeeDto> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeDto getById(@PathVariable int id){
        return employeeService.getById(id);
    }

    @GetMapping("/department/{department}")
    public List<EmployeeDto> getByDepartment(@PathVariable String department){
        return employeeService.getByDepartment(department);
    }

    @GetMapping("salary/{amount}")
    public List<EmployeeDto> getBySalary(@PathVariable double amount){
        return employeeService.getBySalary(amount);
    }

    @PatchMapping("update/{id}")
    public void updateEmployee(@Valid @PathVariable int id, @RequestBody EmployeeDto employeeDto){
        employeeService.updateEmployee(id,employeeDto);
    }

    @DeleteMapping("delete/{id}")
    public void deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
    }
}
