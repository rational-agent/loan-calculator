package com.rationalagent.loancalculator.loan.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

public class ApiError {

    private final HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private final LocalDateTime timestamp;
    private final String message;
    private final List<String> subErrors;

    public ApiError(HttpStatus status, String message, List<String> subErrors) {
        this.status = status;
        this.timestamp = LocalDateTime.now();
        this.message = message;
        this.subErrors = subErrors;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getSubErrors() {
        return subErrors;
    }
}
