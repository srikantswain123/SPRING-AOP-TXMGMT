package com.nt.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

public class ExceptionLoggerAspect {
	public void logger(JoinPoint jp,Exception ex)throws Throwable{
		System.out.println(ex+" exception raiesd from method::"+jp.getSignature()+"With args"+Arrays.deepToString(jp.getArgs()));
	}

}
