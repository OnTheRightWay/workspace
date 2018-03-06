package com.lanou.aop2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Transaction2 {
    @Pointcut("execution(* com.lanou.aop2.UserDaoImpl2.*(..))")
    private void method(){}

    @Before("method()")
    public void begin(JoinPoint joinpoint){
        System.out.println("begin------");
    }
    @After("method()")
    public void commit(JoinPoint joinpoint){
        System.out.println("commit--------");
    }
}
