package com.nt.test;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.IBankService;

public class AspectJAOP_TEST {

	public static void main(String[] args) {
		//creare ioc container Object
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//craete proxy class Object by using target class reference
		IBankService proxy=ctx.getBean("bankService",IBankService.class);
		System.out.println(proxy.getClass()+" "+proxy.getClass().getSuperclass()+"  "+Arrays.toString(proxy.getClass().getInterfaces()));
		//invoke business Object
		System.out.println("simple intrest is "+proxy.simpleIntrest(100000, 2, 23));
		System.out.println("---------------------------------");
		System.out.println("compound intrest is "+proxy.compoundIntrest(100000, 2,23));
		System.out.println("---------------------------------");
		System.out.println("compound intrest is "+proxy.compoundIntrest(100000, 2,23));

	}//main

}//class
