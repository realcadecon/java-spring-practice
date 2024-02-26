package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(-1)
@Component
public class SecurityAspect {

    @Before("com.luv2code.aopdemo.aspect.AopExpressions.excludeGettersAndSetters()")
    public void securityBeforeAllDAOFunctions() {
        System.out.println("===> SEC | Executing advanced security functions!!!");
    }

}
