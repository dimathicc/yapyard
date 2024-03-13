package com.dimathicc.yapyard.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ErrorResponse(
        Integer code,
        String message,
        LocalDateTime timestamp
) {}