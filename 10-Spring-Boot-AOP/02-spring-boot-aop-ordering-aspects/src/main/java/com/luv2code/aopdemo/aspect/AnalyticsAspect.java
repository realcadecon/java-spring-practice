package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class AnalyticsAspect {

    @Before("com.luv2code.aopdemo.aspect.AopExpressions.excludeGettersAndSetters()")
    public void apiAnalyticsBeforeDAOFunctions() {
        System.out.println("===> API | Executing advanced API Analytics functions!!!");
    }

}
