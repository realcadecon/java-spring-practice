package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Aspect
@Order(-2)
@Component
public class LoggingAspect {

    @Before("com.luv2code.aopdemo.aspect.AopExpressions.excludeGettersAndSetters()")
    public void beforeDAOFunctions(JoinPoint theJoinPoint) {
        System.out.println("===> LOG | Executing @Before logging advice on any dao functions");
        System.out.println("\t\t ** Function Name: " + theJoinPoint.getSignature());
        System.out.print("\t\t ** Arguments:");
        for(Object arg : theJoinPoint.getArgs()) {
            if(arg instanceof Integer || arg instanceof String) {
                System.out.print(" " + arg);
            }
        }
        System.out.println();
    }

    @AfterReturning(pointcut = "com.luv2code.aopdemo.aspect.AopExpressions.excludeGettersAndSetters()",
            returning = "accounts")
    private void afterGetAccountsFunction(JoinPoint theJoinPoint, List<Account> accounts) {
        System.out.println("===> LOG | Executing @AfterReturning logging on getAccounts(..)");
        System.out.println("\t\t ** Function Name: " + theJoinPoint.getSignature());
        System.out.print("\t\t ** Accounts Retrieved:\n");
        accounts.stream().forEach(account -> {
            account.setName(convertAccountNameToUppercase(account.getName()));
            System.out.println("\t\t\t" + account);
        });
    }

    private String convertAccountNameToUppercase(String accountName) {
        return accountName.toUpperCase();
    }

    @AfterThrowing(
            pointcut = "com.luv2code.aopdemo.aspect.AopExpressions.excludeGettersAndSetters()",
            throwing = "exception")
    private void catchExceptionsInDAO(JoinPoint joinPoint, Throwable exception) {
        System.out.println("===> LOG | Executing @AfterThrowing logging on getAccounts(..)");
        System.out.println("\t\t ** Function Name: " + joinPoint.getSignature());
        System.out.println("\t\t ** Exception: " + exception);
    }

    @After("com.luv2code.aopdemo.aspect.AopExpressions.excludeGettersAndSetters()")
    public void afterAOPDemoFunctions(JoinPoint joinPoint) {
        System.out.println("\n===> Executing @After advice on any aopdemo functions");
        System.out.println("\t\t ** Function Name: " + joinPoint. getSignature());
    }

    @Around("execution(String *.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("===> Executing @Around on method: " + method);

        long begin = System.currentTimeMillis();
        Object result = null;

//        result = proceedingJoinPoint.proceed();
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            System.out.println("@Around advice: Houston we have a problem ->" + e);
            //result = "There is no war in Ba Sing Se.";
            throw e;
        }
        long end = System.currentTimeMillis();
        long duration = end - begin;
        System.out.println("\t\tDuration: " + duration / 1000 + " seconds");

        return result;
    }

}
