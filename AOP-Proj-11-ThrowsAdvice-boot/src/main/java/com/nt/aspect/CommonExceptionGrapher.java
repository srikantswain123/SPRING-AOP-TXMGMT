package com.nt.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.nt.exception.InvalidInputException;

@Component
@Aspect
public class CommonExceptionGrapher {
	@AfterThrowing(pointcut = "execution(float com.nt.service.Shopping.shop(..))",throwing = "e")

	public void exceptionGrapher(JoinPoint jp,Exception e)throws Throwable{
		throw new InvalidInputException(e.getMessage());
	}

}
