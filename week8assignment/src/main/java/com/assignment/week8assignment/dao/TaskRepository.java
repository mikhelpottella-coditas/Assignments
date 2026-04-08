package com.assignment.week8assignment.dao;


import com.assignment.week8assignment.entity.Priority;
import com.assignment.week8assignment.entity.Status;
import com.assignment.week8assignment.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

    List<Task> findByStatus(Status status);

    List<Task> findByPriority(Priority priority);
}
