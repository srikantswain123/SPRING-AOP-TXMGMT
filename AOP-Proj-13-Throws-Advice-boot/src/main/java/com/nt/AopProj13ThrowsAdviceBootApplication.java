package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.service.Shopping;

@SpringBootApplication
public class AopProj13ThrowsAdviceBootApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(AopProj13ThrowsAdviceBootApplication.class, args);
		//get target class object
		Shopping shop=ctx.getBean("service",Shopping.class);
		//invoke business method
		System.out.println(shop.shop(new String[] {"pant", "shirt","belt"},new float[] {10000,2000,3000}));
	}

}
