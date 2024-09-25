package com.luv2code.springboot.demo.learningapp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(0)
public class MyDemoLoggingAspect {


    @Before("com.luv2code.springboot.demo.learningapp.aspect.AopExpressions.forDaoPackageNotGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("=========== Executing Before Advice on addAccount() ==========");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("MethodSignature: " + methodSignature);

        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println("arg: " + arg);
        }

        System.out.println("======================================================");

    }

}
