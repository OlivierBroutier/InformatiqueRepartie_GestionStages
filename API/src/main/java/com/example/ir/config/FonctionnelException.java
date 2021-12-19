package com.example.ir.config;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import java.util.Locale;
import java.util.Objects;
import org.springframework.http.HttpStatus;

public class FonctionnelException extends Exception {

    private final String code;
    private final String details;
    private final HttpStatus httpStatus;

    public FonctionnelException(String message, String code, HttpStatus httpStatus, String details) {
        super(message);
        this.code = code;
        this.details = details;
        this.httpStatus = Objects.requireNonNullElse(httpStatus, INTERNAL_SERVER_ERROR);
    }

    public FonctionnelException(ErrorEnum errorEnum) {
        this(errorEnum.getDescription(), errorEnum.name(), errorEnum.getStatus(), "");
    }

    public FonctionnelException(ErrorEnum errorEnum, String sup) {
        this(errorEnum.getDescription() + sup, errorEnum.name(), errorEnum.getStatus(), "");
    }

    public FonctionnelException(ErrorEnum errorEnum, String sup, String details) {
        this(
                errorEnum.getDescription() + sup,
                errorEnum.name(),
                errorEnum.getStatus(),
                details);
    }

    public String getCode() {
        return code;
    }

    public String getDetails() {
        return details;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
