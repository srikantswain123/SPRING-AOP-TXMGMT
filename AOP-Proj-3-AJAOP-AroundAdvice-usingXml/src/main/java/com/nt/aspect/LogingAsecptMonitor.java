package com.nt.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogingAsecptMonitor {
	
	public Object loging(ProceedingJoinPoint pjp)throws Throwable {
		System.out.println(pjp.getSignature()+" with args "+Arrays.toString(pjp.getArgs())+" enterd into loging ");
		Object retVal=pjp.proceed();
		System.out.println(pjp.getSignature()+" with args "+Arrays.toString(pjp.getArgs())+" leaved from loging ");
		return retVal;
	}


}
