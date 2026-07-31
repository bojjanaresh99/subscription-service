package com.example.subscription_service.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionAspect {

    private static final Logger logger=
            LoggerFactory.getLogger(ExceptionAspect.class);

    @AfterThrowing(
            pointcut = "execution(* com.example.subscription_service.service.*.*(..))",
            throwing = "exception")
    public void exception(
            JoinPoint joinPoint,
            Exception exception){

        logger.error("Exception in {}",
                joinPoint.getSignature().getName());

        logger.error(exception.getMessage());

    }

}