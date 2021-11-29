package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.cfgs.AppConfig;
import com.nt.service.Shopping;

public class AfterAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		//get proxy object using taget class reference
		Shopping proxy=ctx.getBean("shopping",Shopping.class);
		//invoke business method
		System.out.println("items purchages toatal amount is::"+proxy.shop(new String[] {"shirt", "pant","belt"},
				                                                           new float[] {5000,20000,-1000}));
		//close container
		((AbstractApplicationContext) ctx).close();

	}

}
