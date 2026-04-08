package com.evaluation.week8evaluationtask.controller;

import com.evaluation.week8evaluationtask.annotations.ManagerOnly;
import com.evaluation.week8evaluationtask.entity.Log;
import com.evaluation.week8evaluationtask.service.AuditService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@ManagerOnly
public class AuditController {
    private final AuditService auditService;

    @GetMapping("/get/log")
    public List<Log>     getLog() {
        return auditService.getLog();
    }

}
