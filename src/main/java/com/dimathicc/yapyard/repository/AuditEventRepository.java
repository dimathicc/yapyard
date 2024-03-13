package com.dimathicc.yapyard.repository;

import com.dimathicc.yapyard.model.AuditEventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditEventRepository extends JpaRepository<AuditEventEntity, Long> {
}
