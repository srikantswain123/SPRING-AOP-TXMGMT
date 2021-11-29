package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.IBankDao;

@Service("bankService")
public class BankMgmtServiceImpl implements IBankMgmtService {
	@Autowired
	private IBankDao dao;
	


  @Transactional(propagation = Propagation.REQUIRED,readOnly = false,timeout = 10,transactionManager = "transactionManager")
	@Override
	public boolean transferMoney(long srcAcno, long destAcno, double amt) {
		boolean flag=false;
		if(  dao.withdraw(srcAcno, amt)==0 ||dao.deposite(destAcno, amt)==0) {
			throw new RuntimeException("problem for transfer money");
		}
		else
			flag=true;
		
			return flag;
	}

}
