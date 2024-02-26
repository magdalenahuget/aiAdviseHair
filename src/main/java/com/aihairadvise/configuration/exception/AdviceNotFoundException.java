package com.aihairadvise.configuration.exception;

public class AdviceNotFoundException extends RuntimeException {
    public AdviceNotFoundException(String message) {
        super(message);
    }
}