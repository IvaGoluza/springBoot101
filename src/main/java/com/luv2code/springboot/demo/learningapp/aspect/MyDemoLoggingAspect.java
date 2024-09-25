package com.luv2code.springboot.demo.learningapp.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {


    @Pointcut("execution(* com.luv2code.springboot.demo.learningapp.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("execution(* com.luv2code.springboot.demo.learningapp.dao.*.get*(..))")
    private void getter() {}

    @Pointcut("execution(* com.luv2code.springboot.demo.learningapp.dao.*.set*(..))")
    private void setter() {}

    // combine pointcut
    @Pointcut("forDaoPackage() && !getter() && !setter()")
    private void forDaoPackageNotGetterSetter() {}

    @Before("forDaoPackageNotGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("=========== Executing Before Advice on addAccount() ==========");
    }

    @Before("forDaoPackage()")
    public void performAnalytics() {
        System.out.println("=========== Executing Before Advice & performing Analytics ==========");
    }
}
