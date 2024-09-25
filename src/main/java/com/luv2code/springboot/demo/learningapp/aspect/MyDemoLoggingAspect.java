package com.luv2code.springboot.demo.learningapp.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(0)
public class MyDemoLoggingAspect {


    @Before("com.luv2code.springboot.demo.learningapp.aspect.AopExpressions.forDaoPackageNotGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("=========== Executing Before Advice on addAccount() ==========");
    }

}
