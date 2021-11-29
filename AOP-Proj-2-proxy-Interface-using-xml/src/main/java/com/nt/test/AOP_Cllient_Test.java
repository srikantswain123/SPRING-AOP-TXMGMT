package com.nt.test;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.IBankAccount;

public class AOP_Cllient_Test {

	public static void main(String[] args) {
     //create container
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfg/applicationContext.xml");
		//create target class reference for hold inMemoryProxy class Object and Overriden Method
		IBankAccount proxy=ctx.getBean("pfb",IBankAccount.class);
		System.out.println(proxy.getClass()+" "+proxy.getClass().getSuperclass()+" "+Arrays.toString(proxy.getClass().getInterfaces()));
		//invoke method
		System.out.println("Simple intrest is  "+proxy.calculateIntrest(100000.0f, 2.0f, 12));
		System.out.println("-----------------------------------------");
		System.out.println("Simple intrest is  "+proxy.calculateIntrest(40000.0f, 2.0f, 12));
		
	}//main

}//class
