package com.luv2code.springboot.demo.learningapp.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // POINTCUT EXP: run this code before target-object method with given signature in the specified class
    @Before("execution(public void com.luv2code.springboot.demo.learningapp.dao.AccountDAO.addAccount())")
    public void beforeAddAccountAdvice() {
        System.out.println("=========== Executing Before Advice on addAccount() ==========");
    }
}
