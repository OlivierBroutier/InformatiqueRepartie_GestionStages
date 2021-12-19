package com.example.ir.config;

import java.io.Serializable;
import java.util.Date;

public class ErrorDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    private Date date;
    private String message;
    private String code;
    private String details;

    public ErrorDetails(Date date, String message, String details, String code) {
        super();
        this.date = date;
        this.message = message;
        this.details = details;
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
