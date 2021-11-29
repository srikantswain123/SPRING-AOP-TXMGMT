package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.IBankService;

public class DistributedTxMgmtTest {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//invoke service method
		IBankService proxy=ctx.getBean("service",IBankService.class);
		try {
			System.out.println(proxy.transferMoney(1001, 1005, 1000));
		}catch(Exception e) {
			e.printStackTrace();
		}

	}//main

}//class
