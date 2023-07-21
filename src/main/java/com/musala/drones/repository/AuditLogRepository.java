package com.musala.drones.repository;

import com.musala.drones.models.AuditLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditLogRepository extends CrudRepository<AuditLog, Long> {}
