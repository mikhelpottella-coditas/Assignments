package com.evaluation.week8evaluationtask.controller;

import com.evaluation.week8evaluationtask.entity.Employee;
import com.evaluation.week8evaluationtask.entity.Manager;
import com.evaluation.week8evaluationtask.entity.UserAuth;
import com.evaluation.week8evaluationtask.service.EmployeeService;
import com.evaluation.week8evaluationtask.service.ManagerService;
import com.evaluation.week8evaluationtask.service.UserAuthService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/register")
public class RegisterController {

    private final EmployeeService employeeService;
    private final ManagerService managerService;

    @PostMapping("/employee")
    public Employee registerEmployee(@RequestBody Employee employee) {
        return employeeService.registerEmployee(employee);
    }

    @PostMapping("/manager")
    public Manager registerManager(@RequestBody Manager manager) {
        return managerService.registerManager(manager);
    }


}
