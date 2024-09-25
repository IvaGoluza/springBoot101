package com.luv2code.springboot.demo.learningapp.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // POINTCUT EXP: run this code before any target-object method whose name starts with "add" (in any class)
    @Before("execution(public void add*())")
    public void beforeAddAccountAdvice() {
        System.out.println("=========== Executing Before Advice on addAccount() ==========");
    }
}
