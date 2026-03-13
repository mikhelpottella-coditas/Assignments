package com.evaluation.week6.service;

import com.evaluation.week6.dao.EmployeeDao;
import com.evaluation.week6.dto.EmployeeResponceDto;
import com.evaluation.week6.entity.Employees;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeDao employeeDao;


    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Autowired
    private ModelMapper modelMapper;

    public  List<EmployeeResponceDto> getAll() {
        List<Employees> employees = employeeDao.findAll();
        List<EmployeeResponceDto> employeeResponseDtos = new ArrayList<>();
        employees.forEach(employee -> {
            employeeResponseDtos.add(modelMapper.map(employee, EmployeeResponceDto.class));
        });
        return employeeResponseDtos;
    }

    public  EmployeeResponceDto getById(int id) {
       Employees employees =  employeeDao.findById(id).orElseThrow();
       return modelMapper.map(employees, EmployeeResponceDto.class);
    }

    public  String addEmployee(EmployeeResponceDto employee) {
        Employees employees = modelMapper.map(employee, Employees.class);
        employeeDao.save(employees);
        return "added new employee";
    }

    public String updateEmployee(int id, EmployeeResponceDto employee) {
        Employees employees = modelMapper.map(employee, Employees.class);
        employeeDao.updateById(id,employees);
        return "updated employee";
    }

    public String deleteEmployee(int id) {
        employeeDao.deleteById(id);
        return "deleted employee";
    }

    public List<EmployeeResponceDto> top3() {
        List<Employees> employees = employeeDao.findTop3ByOrderBySalaryDesc();
        List<EmployeeResponceDto> employeeResponseDtos = new ArrayList<>();
        employees.forEach(employee -> {
            employeeResponseDtos.add(modelMapper.map(employee, EmployeeResponceDto.class));
        });
        return employeeResponseDtos;
    }
}
