package com.luv2code.springboot.demo.learningapp.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // POINTCUT EXP: run this code before any target-object method whose name starts with "add"
    // and ACCEPTS ONE ARG OF TYPE Account and any number of args of any type (in any class and with any return type)
    @Before("execution(* add*(com.luv2code.springboot.demo.learningapp.Account, ..))")
    public void beforeAddAccountAdvice() {
        System.out.println("=========== Executing Before Advice on addAccount() ==========");
    }
}
