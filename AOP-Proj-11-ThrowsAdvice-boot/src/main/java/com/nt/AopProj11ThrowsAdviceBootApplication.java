package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.service.Shopping;

@SpringBootApplication
public class AopProj11ThrowsAdviceBootApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(AopProj11ThrowsAdviceBootApplication.class, args);
		Shopping proxy=ctx.getBean("shopping",Shopping.class);
		//invoke business method
		try {
		System.out.println("items purchages toatal amount is::"+proxy.shop(new String[] {"shirt", "pant","belt"},
				                                                           new float[] {5000,20000,1000}));
		}catch(Exception e) {
			e.printStackTrace();
		}
		//close container
         ((AbstractApplicationContext) ctx).close();
	
	
	}

}
