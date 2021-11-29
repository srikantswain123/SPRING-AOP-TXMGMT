package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.config.AppConfig;
import com.nt.service.IBankMgmtService;

public class TxMgmtTest
{
    public static void main( String[] args )
    {
    	
      //create Ioc container
    	ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
    	//crreate servic Object with bean id
    	IBankMgmtService proxy=ctx.getBean("bankService",IBankMgmtService.class);
    	//invoke b.method
    	try {
    		if(proxy.transferMoney(1001, 1005, 2000.0))
    			System.out.println("amount transferd sucessfully");
    		else
    			System.out.println("problem towards money transfer");
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	//close container
    	((AbstractApplicationContext) ctx).close();
    }
}
