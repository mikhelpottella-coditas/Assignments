package com.evaluation.week8evaluationtask.aop;

import com.evaluation.week8evaluationtask.exception.CustomException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ManagerOnlyAop {

    @Before("@annotation(com.evaluation.week8evaluationtask.annotations.ManagerOnly)" +
            "||@within(com.evaluation.week8evaluationtask.annotations.ManagerOnly)")
    public void beforeMethod(JoinPoint joinPoint) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth == null || !auth.isAuthenticated()) throw new CustomException(HttpStatus.UNAUTHORIZED,"user is not authenticated");


        boolean isAdmin = auth.getAuthorities().stream().anyMatch(a-> a.getAuthority().equals("ROLE_MANAGER"));
        if(!isAdmin) throw new CustomException(HttpStatus.FORBIDDEN,"you are not allowed to access");
    }

}
