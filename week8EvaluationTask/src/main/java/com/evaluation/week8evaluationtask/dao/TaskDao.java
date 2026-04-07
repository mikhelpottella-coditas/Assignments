package com.evaluation.week8evaluationtask.dao;

import com.evaluation.week8evaluationtask.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskDao extends JpaRepository<Task, Long> {
}
