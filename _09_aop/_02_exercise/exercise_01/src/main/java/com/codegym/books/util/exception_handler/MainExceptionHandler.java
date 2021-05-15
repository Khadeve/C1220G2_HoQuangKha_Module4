package com.codegym.books.util.exception_handler;

import com.codegym.books.util.custom_exception.OutOfBookException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MainExceptionHandler {
    @ExceptionHandler(OutOfBookException.class)
    public String showPageError() {
        return "/book/out_of_book.error";
    }
}
