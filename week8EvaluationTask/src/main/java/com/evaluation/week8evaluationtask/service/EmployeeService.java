package com.evaluation.week8evaluationtask.service;

import com.evaluation.week8evaluationtask.dao.EmployeeDao;
import com.evaluation.week8evaluationtask.entity.Employee;
import com.evaluation.week8evaluationtask.enums.Roles;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeService {

    private final EmployeeDao employeeDao;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public Employee registerEmployee(Employee employee) {

        employee.getUserAuth().setRole(Roles.EMPLOYEE);
        employee.getUserAuth().setPassword(bCryptPasswordEncoder.encode(employee.getUserAuth().getPassword()));
        return employeeDao.save(employee);
    }


    public Employee getById(Long id) {
        return employeeDao.findById(id).orElseThrow(()-> new RuntimeException("Employee with id " + id + " not found!"));
    }

}
