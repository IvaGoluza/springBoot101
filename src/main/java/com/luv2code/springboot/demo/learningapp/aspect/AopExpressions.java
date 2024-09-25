package com.luv2code.springboot.demo.learningapp.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut("execution(* com.luv2code.springboot.demo.learningapp.dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut("execution(* com.luv2code.springboot.demo.learningapp.dao.*.get*(..))")
    public void getter() {}

    @Pointcut("execution(* com.luv2code.springboot.demo.learningapp.dao.*.set*(..))")
    public void setter() {}

    // combine pointcut
    @Pointcut("forDaoPackage() && !getter() && !setter()")
    public void forDaoPackageNotGetterSetter() {}

}
