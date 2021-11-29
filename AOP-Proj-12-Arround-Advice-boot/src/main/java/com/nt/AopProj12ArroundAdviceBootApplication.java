package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.service.BankService;

@SpringBootApplication
public class AopProj12ArroundAdviceBootApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(AopProj12ArroundAdviceBootApplication.class, args);
		//create Bank Service class object
		BankService proxy=ctx.getBean("bankService",BankService.class);
		//invoke business method
		System.out.println("simple intrest"+proxy.simpleIntrest(100000, 2, 23));
		System.out.println("----------------------------");
		System.out.println("compound intrest"+proxy.compoundIntrest(100000, 2, 23));
		System.out.println("----------------------------------------");
		System.out.println("compound intrest"+proxy.compoundIntrest(100000, 2, 23));
	}

}
