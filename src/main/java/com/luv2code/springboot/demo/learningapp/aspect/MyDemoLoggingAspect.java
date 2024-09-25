package com.luv2code.springboot.demo.learningapp.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // POINTCUT EXP: run this code before any target-object method whose name starts with "add" and ACCEPTS anything
    // HAVE TO specify package name so the wildcard only matches within our project package
    // if not the error is encountered
    @Before("execution(* com.luv2code..add*(..))")
    public void beforeAddAccountAdvice() {
        System.out.println("=========== Executing Before Advice on addAccount() ==========");
    }
}
