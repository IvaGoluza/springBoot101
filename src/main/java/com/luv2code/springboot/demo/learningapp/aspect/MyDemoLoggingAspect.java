package com.luv2code.springboot.demo.learningapp.aspect;

import com.luv2code.springboot.demo.learningapp.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(0)
public class MyDemoLoggingAspect {


    @Before("com.luv2code.springboot.demo.learningapp.aspect.AopExpressions.forDaoPackageNotGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {

        System.out.println("=========== Executing Before Advice ==========");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("MethodSignature: " + methodSignature);

        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println("arg: " + arg);
        }

    }

    @AfterReturning(
            pointcut = "execution(* com.luv2code.springboot.demo.learningapp.dao.AccountDAO.findAccounts(..))" ,
            returning = "results"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> results) {

        System.out.println("=========== Executing AfterReturning Advice on findAccounts() ==========");
        System.out.println("results: " + results);

        if (!results.isEmpty()) {
            Account account = results.get(0);
            account.setName("Updated name inside AfterReturning advice");
        }

    }


    @AfterThrowing(
            pointcut = "execution(* com.luv2code.springboot.demo.learningapp.dao.AccountDAO.findAccounts(..))" ,
            throwing = "theExc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable theExc) {

        System.out.println("=========== Executing AfterThrowing Advice on findAccounts() ==========");
        System.out.println("The exception: " + theExc);
    }


    @After("execution(* com.luv2code.springboot.demo.learningapp.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {

        System.out.println("=========== Executing After Finally Advice ==========");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("MethodSignature: " + methodSignature);

    }


    @Around("execution(* com.luv2code.springboot.demo.learningapp.service.*.getFortune(..))")
    public Object aroundGetFortuneAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        System.out.println("=========== Executing Around Advice ==========");

        long startTime = System.currentTimeMillis();

        Object result = null;

        try {
            result = proceedingJoinPoint.proceed();  // start the method!
        } catch (Exception e) {

            System.out.println("@Around advice - Exception: " + e);
            // handle and give default fortune
            result = "No fortune for you today.";
        }

        long endTime = System.currentTimeMillis();

        long elapsedTime = endTime - startTime;

        System.out.println("Elapsed time: " + elapsedTime / 1000.0 + " s");

        return result; // have to return the result!
    }

}
