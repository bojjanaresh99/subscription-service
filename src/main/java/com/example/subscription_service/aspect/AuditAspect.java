package com.example.subscription_service.aspect;

import com.example.subscription_service.audit.AuditService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditAspect {

    private final AuditService auditService;

    public AuditAspect(AuditService auditService){

        this.auditService=auditService;
    }

    @AfterReturning("execution(* com.example.subscription_service.service.*.*(..))")
    public void audit(JoinPoint joinPoint){

        auditService.saveAudit(
                "SERVICE EXECUTED",
                joinPoint.getSignature().getName());

    }

}