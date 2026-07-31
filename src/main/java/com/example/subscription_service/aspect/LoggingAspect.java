package com.example.subscription_service.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.subscription_service.service.*.*(..))")
    public void beforeMethod(JoinPoint joinPoint) {

        System.out.println("================================================");

        System.out.println("Calling Method : "
                + joinPoint.getSignature().getName());

        System.out.println("================================================");
    }

    @AfterReturning("execution(* com.example.subscription_service.service.*.*(..))")
    public void afterMethod(JoinPoint joinPoint) {

        System.out.println("Method Completed : "
                + joinPoint.getSignature().getName());
    }

    @AfterThrowing(
            pointcut =
            "execution(* com.example.subscription_service.service.*.*(..))",
            throwing = "exception")
    public void exceptionMethod(
            JoinPoint joinPoint,
            Exception exception) {

        System.out.println("Exception in "
                + joinPoint.getSignature().getName());

        System.out.println(exception.getMessage());
    }

}