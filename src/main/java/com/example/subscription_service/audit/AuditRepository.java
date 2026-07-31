package com.example.subscription_service.audit;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditRepository
        extends JpaRepository<AuditLog,Long> {
}