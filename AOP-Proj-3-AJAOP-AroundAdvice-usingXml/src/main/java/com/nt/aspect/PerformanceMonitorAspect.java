package com.nt.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;

public class PerformanceMonitorAspect {
	
	public Object monitor(ProceedingJoinPoint pjp)throws Throwable {
		long start=System.currentTimeMillis();
		System.out.println("entering"+pjp.getSignature()+" with args "+Arrays.toString(pjp.getArgs()));
		Object retVal=pjp.proceed();
		long end=System.currentTimeMillis();
		System.out.println("leaving"+pjp.getSignature()+" with args "+Arrays.toString(pjp.getArgs())+" has taken "+(end-start)+" ms");
		return retVal;
	}
	
	
}
