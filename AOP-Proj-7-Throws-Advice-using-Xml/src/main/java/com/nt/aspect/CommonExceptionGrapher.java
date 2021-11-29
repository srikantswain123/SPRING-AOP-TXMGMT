package com.nt.aspect;

import org.aspectj.lang.JoinPoint;

import com.nt.exception.InvalidInputException;

public class CommonExceptionGrapher {
	public void exceptionGrapher(JoinPoint jp,Exception e)throws Throwable{
		throw new InvalidInputException(e.getMessage());
	}

}
