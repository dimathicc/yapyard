package com.dimathicc.yapyard.config;

import org.springframework.boot.actuate.audit.AuditEventRepository;
import org.springframework.boot.actuate.audit.InMemoryAuditEventRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuditConfiguration {
    @Bean
    public AuditEventRepository repository(){
        return new InMemoryAuditEventRepository();
    }
}
