package com.nt.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExceptionLoggerAspect {
	@AfterThrowing(pointcut = "execution(float com.nt.service.Shopping.shop(..))",throwing = "ex")
	public void logger(JoinPoint jp,Exception ex)throws Throwable{
		System.out.println(ex+" exception raiesd from method::"+jp.getSignature()+"With args"+Arrays.deepToString(jp.getArgs()));
	}

}
