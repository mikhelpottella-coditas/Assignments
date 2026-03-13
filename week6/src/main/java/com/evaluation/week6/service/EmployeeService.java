package com.evaluation.week6.service;

import com.evaluation.week6.dao.EmployeeDao;
import com.evaluation.week6.dto.EmployeeResponseDto;
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

    public  List<EmployeeResponseDto> getAll() {
        List<Employees> employees = employeeDao.findAll();
        List<EmployeeResponseDto> employeeResponseDtos = new ArrayList<>();
        employees.forEach(employee -> {
            employeeResponseDtos.add(modelMapper.map(employee, EmployeeResponseDto.class));
        });
        return employeeResponseDtos;
    }

    public EmployeeResponseDto getById(int id) {
       Employees employees =  employeeDao.findById(id).orElseThrow();
       return modelMapper.map(employees, EmployeeResponseDto.class);
    }

    public  String addEmployee(EmployeeResponseDto employee) {
        Employees employees = modelMapper.map(employee, Employees.class);
        System.out.println(employees);
        employeeDao.save(employees);
        return "added new employee";
    }

    public String updateEmployee(int id, EmployeeResponseDto employee) {

        Employees employees1 = employeeDao.findById(id).get();
        if(employee.getName()!=null) employees1.setName(employee.getName());
        if(employee.getDepartment()!=null) employees1.setDepartment(employee.getDepartment());
        if(employee.getSalary()!=null) employees1.setSalary(employee.getSalary());
        employeeDao.save(employees1);
        return "update success";
    }

    public String deleteEmployee(int id) {
        employeeDao.deleteById(id);
        return "deleted employee";
    }

    public List<EmployeeResponseDto> top3() {
        List<Employees> employees = employeeDao.findTop3ByOrderBySalaryDesc();
        List<EmployeeResponseDto> employeeResponseDtos = new ArrayList<>();
        employees.forEach(employee -> {
            employeeResponseDtos.add(modelMapper.map(employee, EmployeeResponseDto.class));
        });
        return employeeResponseDtos;
    }
}
