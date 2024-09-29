package com.lvadm.currency.exchange.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.lvadm.currency.exchange.service..*(..))")
    public void applicationMethod() {}

    // Log method entry
    @Before("applicationMethod()")
    public void logMethodEntry(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().getDeclaringTypeName();
        log.info("Entering method: {}.{}{}", className, methodName, "()");
    }

    // Log method exit
    @AfterReturning(pointcut = "applicationMethod()")
    public void logMethodExit(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().getDeclaringTypeName();
        log.info("Exiting method: {}.{}{}", className, methodName, "()");
    }

}
