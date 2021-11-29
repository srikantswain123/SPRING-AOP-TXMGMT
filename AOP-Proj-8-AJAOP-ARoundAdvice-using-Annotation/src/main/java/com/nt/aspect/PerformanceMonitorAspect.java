package com.nt.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Component("pmAspect")
@Aspect
@Order(3)
public class PerformanceMonitorAspect {
	
	@Around("execution(float com.nt.service.BankService.*(..))")
	public Object monitor(ProceedingJoinPoint pjp)throws Throwable {
		long start=System.currentTimeMillis();
		Object retVal=pjp.proceed();
		long end=System.currentTimeMillis();
		System.out.println(pjp.getSignature()+" with args "+Arrays.toString(pjp.getArgs())+" has taken "+(end-start)+" ms");
		return retVal;
	}
	
	
}
