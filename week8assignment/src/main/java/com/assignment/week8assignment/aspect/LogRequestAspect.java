package com.assignment.week8assignment.aspect;

import com.assignment.week8assignment.dao.TaskRepository;
import com.assignment.week8assignment.entity.Priority;
import com.assignment.week8assignment.entity.Status;
import com.assignment.week8assignment.entity.Task;
import com.assignment.week8assignment.exception.ExceptionHandle;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogRequestAspect {


//    ● Log API request

    @Before("execution(* com.assignment.week8assignment.controller.TaskController..*(..))")
    public void logCreateTaskBefore() {
        System.out.println("Creating Task started");
    }


    @After("execution(* com.assignment.week8assignment.controller.TaskController..*(..))")
    public void logCreateTaskAfter() {
        System.out.println("Creating Task ended");
    }


    //    Execution time logging
    @Around("within(com.assignment.week8assignment.controller..*)")
    public Object TimeTook(ProceedingJoinPoint jp) throws Throwable {

        long startTime = System.currentTimeMillis();
        Object returnValue = jp.proceed();

        long endTime = System.currentTimeMillis();
        System.out.println(jp.getSignature().getName() + " Execution Time Took " + (endTime - startTime) + "ms");
        return returnValue;

    }


    @AfterThrowing(
            pointcut = "execution(* com.assignment.week8assignment.service..*(..))",
            throwing = "ex"
    )
    public void handleException(JoinPoint jp, Exception ex) {
        System.out.println("Exception in method: " + jp.getSignature().getName());
        System.out.println("Error: " + ex.getMessage());
    }


    @Autowired
    TaskRepository taskRepository;

    @Before("execution(* com.assignment.week8assignment.service.TaskService.updateStatusById(..))")
    public void validateTaskBefore(JoinPoint jp) {
        System.out.println("Validating Task started");


        Status args = (Status) jp.getArgs()[1];

        Task task = taskRepository.findById((Long)jp.getArgs()[0]).orElseThrow();

        System.out.println("Status: " + args.toString());

        Status currentStatus = task.getStatus();

        if(currentStatus==Status.ASSIGNED && args == Status.IN_PROGRESS) {
            System.out.println("IN progress Task");
            return;
        }
        else if(currentStatus==Status.IN_PROGRESS && args == Status.COMPLETED) {
            System.out.println("Completed Task");
            return;
        }
        else if (currentStatus == Status.COMPLETED) {
            throw new RuntimeException("Task is already completed. No further updates allowed.");
        }


        System.out.println("Invalid Task Status");
        throw new ExceptionHandle(HttpStatus.NOT_ACCEPTABLE,"this is not valid status according to the progress");


    }


    @Before("execution(* com.assignment.week8assignment.service.TaskService.updateStatusById(..))")
    public void validateTaskBeforeToCheckPriority(JoinPoint jp) {
        System.out.println("Validating Task started");


        Priority args = (Priority) jp.getArgs()[1];

        Task task = taskRepository.findById((Long)jp.getArgs()[0]).orElseThrow();

        System.out.println("Status: " + args.toString());

        Status currentStatus = task.getStatus();

        if(task.getPriority()==args){
            throw new ExceptionHandle(HttpStatus.NOT_ACCEPTABLE,"this is the current priority. no updates allowed.");
        }

    }



    // let's secure the endpoint by giving permission only to manager
    @Before("execution(* com.assignment.week8assignment.service.TaskService.updateStatusById(..))")
    public void validateUserBefore(JoinPoint jp) {
        System.out.println("Validating User started");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        assert authentication != null;
        String role = authentication.getAuthorities().iterator().next().getAuthority();

        System.out.println("Role: " + role);


        assert role != null;
        if(!role.equals("ROLE_MANAGER")){
            throw new ExceptionHandle(HttpStatus.NOT_ACCEPTABLE,"you don't have the authority");
        }
    }


    @Before("execution(* com.assignment.week8assignment.service.TaskService.deleteTaskById(..))")
    public void validateUserBeforeDelete(JoinPoint jp) {
        System.out.println("Validating User started");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        assert authentication != null;
        String role = authentication.getAuthorities().iterator().next().getAuthority();

        System.out.println("Role: " + role);


        assert role != null;
        if(!role.equals("ROLE_MANAGER")){
            throw new ExceptionHandle(HttpStatus.NOT_ACCEPTABLE,"you don't have the authority");
        }
    }




}
