package com.learning.week6assignment.service;

import com.learning.week6assignment.DAO.EmployeeDao;
import com.learning.week6assignment.DTO.EmployeeDto;
import com.learning.week6assignment.entity.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    Employees employees;
    EmployeeDao employeeDao;

    @Autowired
    public EmployeeService(Employees employees, EmployeeDao employeeDao) {
        this.employees = employees;
        this.employeeDao = employeeDao;
    }


    public void register(EmployeeDto employeeDto) {

        if(employeeDao.existsByEmail(employeeDto.getEmail())){
            throw new RuntimeException("Email already exist");
        }

        Employees employees = new Employees();
        employees.setFirstName(employeeDto.getFirstName());
        employees.setLastName(employeeDto.getLastName());
        employees.setDepartment(employeeDto.getDepartment());
        employees.setEmail(employeeDto.getEmail());
        employees.setSalary(employeeDto.getSalary());



        employeeDao.save(employees);


    }

    public List<EmployeeDto> getAllEmployees() {
        List<Employees> employeesList =  employeeDao.findAll();
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        employeesList.forEach(e->employeeDtoList.add(new EmployeeDto(e.getId(),e.getFirstName(),e.getLastName(),e.getEmail(),e.getDepartment(),e.getSalary())));
        return employeeDtoList;
    }

    public EmployeeDto getById(int id) {
        employees = employeeDao.findById(id).orElseThrow(()->new RuntimeException("Employee not not found"));
        return new EmployeeDto(employees.getId(), employees.getFirstName(), employees.getLastName(), employees.getEmail(), employees.getDepartment(), employees.getSalary());
    }

    public List<EmployeeDto> getByDepartment(String department) {
        List<Employees> employeesList =  employeeDao.findAllByDepartment(department);
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        employeesList.forEach(employees->employeeDtoList.add(new EmployeeDto(employees.getId(), employees.getFirstName(), employees.getLastName(), employees.getEmail(), employees.getDepartment(), employees.getSalary())));
        return employeeDtoList;
    }


    public List<EmployeeDto> getBySalary(double amount) {
        List<Employees> employeesList =  employeeDao.findBySalaryGreaterThan(amount);
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        employeesList.forEach(employees->employeeDtoList.add(new EmployeeDto(employees.getId(), employees.getFirstName(), employees.getLastName(), employees.getEmail(), employees.getDepartment(), employees.getSalary())));
        return employeeDtoList;
    }


    public void updateEmployee(int id, EmployeeDto employeeDto) {
        employees = employeeDao.findById(id).orElseThrow(()->new RuntimeException("Employee not found"));

//

        if(employeeDto.getFirstName()!=null) employees.setFirstName(employeeDto.getFirstName());
        if(employeeDto.getLastName()!=null) employees.setLastName(employeeDto.getLastName());
        if(employeeDto.getDepartment()!=null) employees.setDepartment(employeeDto.getDepartment());
        if(employeeDto.getSalary()!=null) employees.setSalary(employeeDto.getSalary());

        employeeDao.save(employees);

    }

    public void deleteEmployee(int id) {
        if(!employeeDao.existsById(id)) throw  new RuntimeException("Employee not found to delete");
        else employeeDao.deleteById(id);
    }
}
