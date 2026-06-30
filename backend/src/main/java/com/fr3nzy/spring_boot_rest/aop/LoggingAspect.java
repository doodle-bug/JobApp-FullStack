package com.fr3nzy.spring_boot_rest.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
//    Creates a Logger for the LoggingAspect class to print log messages.
//    @Slf4j is a Lombok annotation that auto-generates this line for you:

    // return type, class-name.method-name(args)
    // * means all and for arguments we use ..

    /*
    so this method will be called before the execution of all the return type,
    of all the classes in the path having all the methods with all the arguments
     */
    // @Before("execution(* *.*(..))")

    @Before("execution(* com.fr3nzy.spring_boot_rest.service.JobService.getJob(..)) || execution(* com.fr3nzy.spring_boot_rest.service.JobService.updateJob(..))")
    public void logMethodCalled(JoinPoint jp){
        LOGGER.info("Method called " + jp.getSignature().getName());
    }

    /*
     @Before("execution(* com.fr3nzy.spring_boot_rest.service.JobService.getJob(..)) || execution(* com.fr3nzy.spring_boot_rest.service.JobService.updateJob(..))")
     public void logMethodCalled(JoinPoint jp){
         log.info("Method called " + jp.getSignature().getName());
     }
    */
//    When using @Slf4j we can directly use log methods without declaring logger class

    @After("execution(* com.fr3nzy.spring_boot_rest.service.JobService.getJob(..)) || execution(* com.fr3nzy.spring_boot_rest.service.JobService.updateJob(..))")
    public void logMethodExecuted(JoinPoint jp){
        LOGGER.info("Method executed " + jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.fr3nzy.spring_boot_rest.service.JobService.getJob(..)) || execution(* com.fr3nzy.spring_boot_rest.service.JobService.updateJob(..))")
    public void logMethodCrashed(JoinPoint jp){
        LOGGER.info("Method has some issue " + jp.getSignature().getName());
    }
}
