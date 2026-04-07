package com.evaluation.week8evaluationtask.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAop {

    private static final Logger log = LogManager.getLogger(ServiceAop.class);

    @Around("within(com.evaluation.week8evaluationtask.service)")
    public Object serviceeAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("the '"+ joinPoint.getSignature().getName() +"' service is called");
        Object result =  joinPoint.proceed();
        log.info("the '"+ joinPoint.getSignature().getName() +"' service is finished");
        return result;
    }


}
