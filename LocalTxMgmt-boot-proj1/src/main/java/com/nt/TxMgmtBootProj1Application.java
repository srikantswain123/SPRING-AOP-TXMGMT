package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.service.IBankMgmtService;

@SpringBootApplication
public class TxMgmtBootProj1Application {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(TxMgmtBootProj1Application.class, args);
		//invoke business method
		IBankMgmtService proxy=ctx.getBean("bankService",IBankMgmtService.class);
		try {
			if(proxy.transferMoney(1001, 1005, 2000))
				System.out.println("Amount sucessfully transferd");
			System.out.println(proxy.getClass());
		}catch(Exception e) {
			e.printStackTrace();
		}
		//close ioc container
		((ConfigurableApplicationContext) ctx).close();
	}

}
