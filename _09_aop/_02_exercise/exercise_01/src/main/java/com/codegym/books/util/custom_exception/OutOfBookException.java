package com.codegym.books.util.custom_exception;

public class OutOfBookException extends Exception {
    public OutOfBookException() {
    }

    public OutOfBookException(String message) {
        super(message);
    }
}
