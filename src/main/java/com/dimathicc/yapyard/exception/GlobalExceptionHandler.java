package com.dimathicc.yapyard.exception;

import com.dimathicc.yapyard.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({
            UserNotFoundException.class
    })
    public ResponseEntity<ErrorResponse> handleBadGatewayException(Exception e) {
        return defaultErrorResponse(e, HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler({
            UserAlreadyExists.class
    })
    public ResponseEntity<ErrorResponse> handleBadRequestException(Exception e) {
        return defaultErrorResponse(e, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<ErrorResponse> defaultErrorResponse(Exception e, HttpStatus httpStatus) {
        ErrorResponse response = new ErrorResponse(httpStatus.value(), e.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(response, httpStatus);
    }
}
