package com.evaluation.week8evaluationtask.dao;

import com.evaluation.week8evaluationtask.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface LogDao extends JpaRepository<Log, Long> {
}
