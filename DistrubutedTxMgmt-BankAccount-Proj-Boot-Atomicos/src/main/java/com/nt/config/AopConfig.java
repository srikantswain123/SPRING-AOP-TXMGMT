package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;

@Configuration
public class AopConfig {

	@Bean("transactionService")
	public UserTransactionImp service() {
		return new UserTransactionImp();
	}
	
	@Bean("transactionManager")
	public UserTransactionManager manager() {
		return new UserTransactionManager();
	}
	
	//configure jta
	
	@Bean("jtaTransaction")
	public JtaTransactionManager jtaTxmgmt() {
		JtaTransactionManager mgmr=new JtaTransactionManager();
		mgmr.setUserTransaction(service());
		mgmr.setTransactionManager(manager());
		return mgmr;
	}
	
	
}
