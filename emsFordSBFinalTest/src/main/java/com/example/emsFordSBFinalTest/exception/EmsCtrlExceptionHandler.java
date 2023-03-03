package com.example.emsFordSBFinalTest.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class EmsCtrlExceptionHandler {
    @Autowired
    Environment environment;
    @ExceptionHandler(EmsNotFoundException.class)
    public ResponseEntity<EmsErrorInfo> handleBookNotFoundException(EmsNotFoundException ex){
        EmsErrorInfo info = new EmsErrorInfo();
        info.setErrorCode(HttpStatus.NOT_FOUND.value());
        info.setMessage(environment.getProperty("Employee_Not_Found_Exception"));
        info.setTime(LocalDateTime.now());
        return new ResponseEntity<EmsErrorInfo>(info,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<EmsErrorInfo> exceptionHandler(ConstraintViolationException exception) {
        EmsErrorInfo errorInfo = new EmsErrorInfo();
        errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
        errorInfo.setTime(LocalDateTime.now());

        String errorMsg = exception.getConstraintViolations().stream().map((cv)->cv.getMessage()).collect(Collectors.joining(","));
        errorInfo.setMessage(errorMsg);

        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }
}
