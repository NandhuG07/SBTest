package com.example.emsFordSBFinalTest.exception;

import java.time.LocalDateTime;

public class EmsErrorInfo {
    private String message;
    private Integer errorCode;
    private LocalDateTime time;

    public EmsErrorInfo() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}