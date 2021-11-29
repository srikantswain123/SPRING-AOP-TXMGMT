package com.nt.advice;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class MonitoringAdvice implements org.aopalliance.intercept.MethodInterceptor  {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		long start=System.currentTimeMillis();
		System.out.println(invocation.getClass()+" "+Arrays.toString(invocation.getClass().getInterfaces()));
		Object args[]=invocation.getArguments();
		//modify target method arguments
		if(((float)args[0])<50000)
		args[1]=((float)args[1])-0.05f;
		//control target method excution
		if(((float)args[0])<0||((float)args[1])<0|((int)args[2])<0)
			throw new IllegalArgumentException("invalid inputs -ve value not allowed");
		Object returnVal=invocation.proceed();
		//modify return val
		returnVal=((float)returnVal)+((float)returnVal)*0.05f;
		long end=System.currentTimeMillis();
		System.out.println(invocation.getMethod().getName()+"  with args "+Arrays.toString(invocation.getArguments())+" has taken"+(end-start)+" ms");
		return returnVal;
	}


}
