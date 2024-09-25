package com.luv2code.springboot.demo.learningapp.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(-10)  // order number can be negative
public class MyApiAnalyticsAspect {

    @Before("com.luv2code.springboot.demo.learningapp.aspect.AopExpressions.forDaoPackageNotGetterSetter()")
    public void performAnalytics() {
        System.out.println("=========== Executing Before Advice & performing Analytics ==========");
    }

}
