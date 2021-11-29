package com.nt.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("login")
@Aspect
@Order(2)
public class LogingAsecptMonitor {
	
	@Around("execution(float com.nt.service.BankService.*(..))")
	public Object loging(ProceedingJoinPoint pjp)throws Throwable {
		System.out.println(pjp.getSignature()+" with args "+Arrays.toString(pjp.getArgs())+" enterd into loging ");
		Object retVal=pjp.proceed();
		System.out.println(pjp.getSignature()+" with args "+Arrays.toString(pjp.getArgs())+" leaved from loging ");
		return retVal;
	}


}
