package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class AopExpressions {
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut("execution(* *.get*(..))")
    public void getter() {}

    @Pointcut("execution(* *.set*(..))")
    public void setter() {}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void excludeGettersAndSetters() {}
}
