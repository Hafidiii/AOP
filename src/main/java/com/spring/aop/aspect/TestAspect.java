package com.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

/*
Compile time
        Aspect : is the functionality that we are trying to implement generally
        Pointcut: A regular expression that determines what are the methods calls that i want to intercept
        Advice: action to be done when the pointcut is intercepted

Runtime
        Join Point: in Spring AOP its a pointcut execution
        Weaver is the framework which implements AOP - AspectJ or Spring AOP.


@After - Executed in two situations - when a method executes successfully or it throws an exception.
@AfterReturning - Executed only when a method executes successfully.
@AfterThrowing - Executed only when a method throws an exception.
@Before annotation is used to create Before advice
If we will create Employee bean using new operator the advices will not be applied. Only when we will use ApplicationContext to get the bean, advices will be applied.
Aspect classes are required to have @Aspect annotation.
The string parameter passed in the @Before annotation is the Pointcut expression

* */

@Aspect
@Configuration
public class TestAspect {

    /*
    *
    * Around advice are always required to have ProceedingJoinPoint as an argument and we should use it’s proceed() method to invoke the target object advised method.
    * If advised method is returning something, it’s advice responsibility to return it to the caller program. For void methods, advice method can return null.
    * Since around advice cut around the advised method, we can control the input and output of the method as well as it’s execution behavior.
    *
    * */
    @Around("pointCut()")
    public Object sumAroundAdvice(ProceedingJoinPoint joinPoint){
        Object value= null;
        System.out.println(joinPoint.getSignature().getName().toUpperCase() + " method BEFORE around...");
        try {
            value = joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
            return 0;
        }
        System.out.println(joinPoint.getSignature().getName().toUpperCase() + " method AFTER around...");
        return Integer.valueOf(value.toString()) +1;
    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName().toUpperCase() + " method BEFORE starting...");
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        System.out.println(joinPoint.getSignature().getName().toUpperCase() + " method AFTER RETURNING : " + result.toString());

    }

    @AfterThrowing(value = "pointCut()")
    public void afterThrowing(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName().toUpperCase() + " throws an exception..");

    }

    @After("pointCut()")
    public void after(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName().toUpperCase() + " method AFTER starting...");
    }

    //Pointcut to execute on all the methods of classes in a package
    @Pointcut("execution(* com.spring.aop.service.TestService.*(..))")
    public void pointCut(){}

    //Pointcut to to apply the advice to all the methods in the class
    @Pointcut("within(com.spring.aop.service.TestService)")
    public void pointCutWithin(){}

}
