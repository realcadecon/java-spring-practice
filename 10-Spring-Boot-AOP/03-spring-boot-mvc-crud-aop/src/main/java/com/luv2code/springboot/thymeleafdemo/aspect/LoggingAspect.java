package com.luv2code.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Before("com.luv2code.springboot.thymeleafdemo.aspect.PointcutExpressions.forAppFlow()")
    public void before(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        myLogger.info("===> in @Before: calling method: " + method);

        //get and display arguments
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            myLogger.info("======> argument: " + arg);
        }
    }

    @AfterReturning(
            pointcut = "com.luv2code.springboot.thymeleafdemo.aspect.PointcutExpressions.forAppFlow()",
            returning = "result")
    public void after(JoinPoint joinPoint, Object result) {
        String method = joinPoint.getSignature().toShortString();
        myLogger.info("===> in @AfterReturning: from method: " + method);

        //get and display return result
        myLogger.info("======> return result: " + result);

    }

}
