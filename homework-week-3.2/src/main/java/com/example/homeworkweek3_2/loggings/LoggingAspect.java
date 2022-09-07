package com.example.homeworkweek3_2.loggings;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
    @Before("execution(* com..homeworkweek3_2..DepartmentController.getDepartmentDto(..))")
    public void before(JoinPoint joinPoint){
        LOGGER.info(String.format("Logging running before run getDepartmentDto(),(%s) ", joinPoint.toString()));
    }
    @After("execution(* com..homeworkweek3_2..DepartmentController.getDepartmentDto(..))")
    public void after(JoinPoint joinPoint){
        LOGGER.info(String.format("Logging running after run getDepartmentDto(),(%s) ", joinPoint.toString()));
    }
    @AfterThrowing(value = "execution(* com..homeworkweek3_2..EmployeeController.getDepartmentDto(..))", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex){
        LOGGER.error("Get {} at {}", ex.getMessage(), joinPoint.toString());
    }
}
