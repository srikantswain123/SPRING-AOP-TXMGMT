package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.BankService;

public class AspectJAOP_TEST {

	public static void main(String[] args) {
		//creare ioc container Object
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//craete proxy class Object by using target class reference
		BankService service=ctx.getBean("bankService",BankService.class);
		//invoke business Object
		System.out.println("simple intrest is "+service.simpleIntrest(100000, 2, 23));
		System.out.println("---------------------------------");
		System.out.println("compound intrest is "+service.compoundIntrest(100000, 2,23));
		System.out.println("---------------------------------");
		System.out.println("compound intrest is "+service.compoundIntrest(100000, 2,23));

	}

}
