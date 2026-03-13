package com.evaluation.week6.dao;

import com.evaluation.week6.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao extends JpaRepository<Employees, Integer> {

    public void updateById(int id, Employees employees);

    public List<Employees> findTop3ByOrderBySalaryDesc();

}
