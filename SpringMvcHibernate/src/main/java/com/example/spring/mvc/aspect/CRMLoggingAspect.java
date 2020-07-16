package com.example.spring.mvc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    // Loglama yapmak icin
    private Logger logger = Logger.getLogger(getClass().getName());

    //Paketler icin baglanti noktalari
    @Pointcut("execution( * com.example.spring.mvc.controller.*.*(..) )")
    private void forControllerPackage() {
    }

    @Pointcut("execution( * com.example.spring.mvc.controller.*.*(..) )")
    private void forServicePackage() {
    }

    @Pointcut("execution( * com.example.spring.mvc.dao.*.*(..))")
    private void forDaoPackage() {
    }

    //Tum pointcutlar icin
    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {
    }

    //Method parametrelerini yakalamak icin
    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {

        Object[] argList = joinPoint.getArgs();

        if (argList.length != 0) {
            //Methodu bastirir
            logger.info("======>>>Method: " + joinPoint.getSignature());
            for (Object o : argList)
                logger.info("======>>>" + o);
        }


    }

    //Methodların return degerlerini yakalamak icin
    @AfterReturning(pointcut = "forAppFlow()", returning = "result")
    public void after(JoinPoint joinPoint, Object result) {




            logger.info("======>>>Method: " + joinPoint.getSignature());

            logger.info("======>>>Result: "+result);


    }


}
