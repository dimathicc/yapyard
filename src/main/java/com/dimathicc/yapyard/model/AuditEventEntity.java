package com.dimathicc.yapyard.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "audit")
public class AuditEventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(name = "timestamp")
    private Instant timestamp;

    @Column(name = "username")
    private String  username;

    @Column(name = "request_parameters")
    private String requestParameters;




}
