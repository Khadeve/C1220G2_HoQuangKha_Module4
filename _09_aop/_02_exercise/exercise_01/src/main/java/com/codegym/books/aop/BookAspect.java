package com.codegym.books.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
public class BookAspect {
    @Pointcut("execution(* com.codegym.books.services.impl.RentCodeService.*(com.codegym.books.models.RentCode))")
    public void checkRentCodeController(){}

    @Pointcut("execution(* com.codegym.books.services.impl..*.*(..))")
    public void allActions(){}

    @After("checkRentCodeController()")
    public void afterRentOrReturnBook(JoinPoint joinpoint) {
        System.out.println("Action: " + joinpoint.getTarget().getClass().getSimpleName() + "."
                + joinpoint.getSignature().getName() +
                        ", Time: " + LocalDateTime.now());
    }

    @After("execution(public * com.codegym.books.services.impl.BookService.save(..))")
    public void afterCreateNewBook(JoinPoint joinPoint) {
        System.out.println("Create new book at " + LocalDateTime.now());
    }

    @After("allActions()")
    public void afterAnyAction(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(String.format("An action is executed on %s.%s%s", className, method, args));
    }
}
