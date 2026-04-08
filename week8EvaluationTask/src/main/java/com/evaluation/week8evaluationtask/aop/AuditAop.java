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


    @AfterThrowing(pointcut = "execution(* com.evaluation.week8evaluationtask.controller.TaskController.*(..))",
            throwing = "ex" )
    public void logAfterThrowing(JoinPoint joinPoint, Exception ex) {
        Object[] args = joinPoint.getArgs();
        String methodName = joinPoint.getSignature().getName();

        String argsStr = "";
        for (Object arg : args) {
            System.out.println(methodName + ": " + arg);
            argsStr = argsStr + arg;
        }


        Log log = new Log();
        log.setMethodName(methodName);
        log.setArguments(argsStr);
        log.setMessage(ex.getMessage());
        log.setStatus("FAIL");
        logDao.save(log);

        throw new CustomException(HttpStatus.NOT_ACCEPTABLE,ex.getMessage());
    }

    @AfterReturning(pointcut = "execution(* com.evaluation.week8evaluationtask.controller.TaskController.*(..))",
            returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println(">>>>> AOP");
        Object[] args = joinPoint.getArgs();
        String methodName = joinPoint.getSignature().getName();

        String argsStr = "";
        for (Object arg : args) {
            System.out.println(methodName + ": " + arg);
            argsStr = argsStr + arg;
        }


        Log log = new Log();
        log.setMethodName(methodName);
        log.setArguments(argsStr);
        log.setMessage(methodName+" execution successfully");
        log.setStatus("FAIL");
        logDao.save(log);

    }
}
