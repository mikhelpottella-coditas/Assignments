package com.evaluation.week8evaluationtask.dao;

import com.evaluation.week8evaluationtask.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long> {
}
