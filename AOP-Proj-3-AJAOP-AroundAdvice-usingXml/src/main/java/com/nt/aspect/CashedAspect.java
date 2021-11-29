package com.nt.aspect;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;

public class CashedAspect {
	private Map<String,Object> map=new  LinkedHashMap<String, Object>();
	
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
