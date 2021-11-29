package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.service.AuthenticationManager;
import com.nt.service.IBankService;

@SpringBootApplication
public class AopProj14BeforeAdviceBootApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(AopProj14BeforeAdviceBootApplication.class, args);
		//get Proxy object
				IBankService proxy=ctx.getBean("bankService",IBankService.class);
				//get AuthenticationManager object
				AuthenticationManager manager=ctx.getBean("manger",AuthenticationManager.class);
				try {
				   manager.signIn("raja", "rani");
				   System.out.println("withdraw operation::"+proxy.withdrawMoney(1001, 2000));
				   System.out.println("deposite operation::"+proxy.depositeMoney(1002, 2000));
				   manager.signOut();
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
				
				//close container
				((AbstractApplicationContext) ctx).close();

	}

}
