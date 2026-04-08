package com.evaluation.week8evaluationtask.service;

import com.evaluation.week8evaluationtask.dao.LogDao;
import com.evaluation.week8evaluationtask.entity.Log;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuditService {
    private final LogDao logDao;


    public List<Log> getLog() {
        return logDao.findAll();
    }
}
