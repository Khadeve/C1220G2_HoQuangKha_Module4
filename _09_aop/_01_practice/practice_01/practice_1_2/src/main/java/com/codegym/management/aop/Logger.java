package com.codegym.management.aop;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    public void error() {
        System.out.println("[CMS] error");
    }

    @AfterThrowing(pointcut = "execution(public * com.codegym.management.services.customer.CustomerService.*(..))")
    public void log() {
        System.out.println("Exception thrown!");
    }
}
