package com.dimathicc.yapyard.config;

import com.dimathicc.yapyard.model.AuditEventEntity;
import com.dimathicc.yapyard.repository.AuditEventRepository;
import org.springframework.boot.actuate.audit.AuditEvent;
import org.springframework.boot.actuate.audit.InMemoryAuditEventRepository;
import org.springframework.boot.actuate.audit.listener.AbstractAuditListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AuditListener extends AbstractAuditListener {



    private final AuditEventRepository auditEventRepository;

    public AuditListener(AuditEventRepository auditEventRepository) {
        this.auditEventRepository = auditEventRepository;
    }

    @Override
    protected void onAuditEvent(AuditEvent event) {
        AuditEventEntity auditEventEntity = new AuditEventEntity();
        auditEventEntity.setTimestamp(event.getTimestamp());
        auditEventEntity.setUsername(event.getPrincipal());
        auditEventEntity.setRequestParameters(event.getType());

        auditEventRepository.save(auditEventEntity);
    }
}