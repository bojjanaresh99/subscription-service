package com.example.subscription_service.audit;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuditService {

    private final AuditRepository repository;

    public AuditService(AuditRepository repository){

        this.repository=repository;
    }

    public void saveAudit(String action,String method){

        AuditLog audit=new AuditLog();

        audit.setAction(action);

        audit.setMethodName(method);

        audit.setUsername("SYSTEM");

        audit.setCreatedAt(LocalDateTime.now());

        repository.save(audit);

    }

}