package com.learning.week6assignment.DAO;

import com.learning.week6assignment.entity.Employees;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao extends JpaRepository<Employees, Integer> {

    boolean existsByEmail(String email);

// to get all the emps of the same dept
    List<Employees> findAllByDepartment(String department);

    // to get emps salary greaterThan given amount
    List<Employees> findBySalaryGreaterThan(double salary);
}
