package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.service.IBankService;

@SpringBootApplication
public class DistrubutedTxMgmtBankAccountProjBootAtomicosApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(DistrubutedTxMgmtBankAccountProjBootAtomicosApplication.class, args);
	//get bankService Object
		IBankService proxy=ctx.getBean("bankService",IBankService.class);
		//invoke business method
		System.out.println(proxy.transferMoney(1001, 1003, 2000));
	
	
	
	
	}

}
