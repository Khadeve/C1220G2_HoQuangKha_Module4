package com.codegym.management.services.util;

public class DuplicateEmailException extends Exception {
    public DuplicateEmailException() {
    }

    public DuplicateEmailException(String message) {
        super(message);
    }
}
