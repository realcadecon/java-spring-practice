package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {}

    @Before("execution(* com.luv2code.aopdemo.*.*.*(..))")
    public void beforeAllAOPDemoFunctions() {
        System.out.println("\n===> Executing @Before advice on any aopdemo functions");
    }

    @Before("forDaoPackage()")
    public void beforeDAOFunctions() {
        System.out.println("======>>>> Executing @Before advice on any dao functions");
    }
}
