package com.example.emsFordSBFinalTest.exception;

public class EmsNotFoundException extends RuntimeException {
    public EmsNotFoundException(String message) {
        super(message);
    }
}