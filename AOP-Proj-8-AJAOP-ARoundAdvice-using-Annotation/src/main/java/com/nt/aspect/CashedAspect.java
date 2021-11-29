package com.nt.aspect;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Component("cashAspect")
@Aspect
@Order(1)
public class CashedAspect {
	private Map<String,Object> map=new  LinkedHashMap<String, Object>();
	
	@Around("execution(float com.nt.service.BankService.*(..))")
	public Object cashed(ProceedingJoinPoint pjp)throws Throwable{
		String key=pjp.getSignature()+Arrays.toString(pjp.getArgs());
		Object retVal=null;
		if(!map.containsKey(key)) {
			System.out.println(" from target class");
			retVal=pjp.proceed();
			map.put(key, retVal);
		}else {
			System.out.println("Cashed");
			retVal=map.get(key);
		}
		return retVal;
	}//cashed method

}
