package com.evaluation.week8evaluationtask.aop;

import com.evaluation.week8evaluationtask.dao.LogDao;
import com.evaluation.week8evaluationtask.entity.Log;
import com.evaluation.week8evaluationtask.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@RequiredArgsConstructor
public class AuditAop {

    private final LogDao logDao;


    @AfterThrowing(pointcut = "execution(* com.evaluation.week8evaluationtask.controller.AssignTaskController.*(..))",
            throwing = "ex" )
    public void logAfterThrowing(JoinPoint joinPoint, Exception ex) {
        Object[] args = joinPoint.getArgs();
        String methodName = joinPoint.getSignature().getName();



        Log log = new Log();
        log.setMethodName(methodName);
        String argString = Arrays.toString(args);
        log.setArguments(argString);
        log.setMessage(ex.getMessage());
        log.setStatus("FAIL");
        logDao.save(log);

        throw new CustomException(HttpStatus.NOT_ACCEPTABLE,ex.getMessage());
    }

    @AfterReturning(pointcut = "execution(* com.evaluation.week8evaluationtask.controller.AssignTaskController.*(..))",
            returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        Object[] args = joinPoint.getArgs();
        String methodName = joinPoint.getSignature().getName();

        Log log = new Log();
        log.setMethodName(methodName);
        String argString = Arrays.toString(args);
        log.setArguments(argString);
        log.setMessage(methodName+" execution successfully done!!");
        log.setStatus("FAIL");
        logDao.save(log);

    }
}
