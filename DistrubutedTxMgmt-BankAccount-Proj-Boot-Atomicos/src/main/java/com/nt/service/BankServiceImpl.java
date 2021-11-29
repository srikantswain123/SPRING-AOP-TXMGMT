package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.IDepositeDao;
import com.nt.dao.IWithDrawDao;

@Service("bankService")
public class BankServiceImpl implements IBankService {
	
	@Autowired
	private IDepositeDao depoDao;
	@Autowired
	private IWithDrawDao withDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly =false,transactionManager = "jtaTransaction")
	public String transferMoney(long srcAcno, long destAcno, double amt) {
		int count1=withDao.Withdraw(srcAcno, amt);
		int count2=depoDao.deposite(destAcno, amt);
		if(count1==0 || count2==0)
			throw new RuntimeException("problem towards transfer money");
		else
		return "Transfer money sucessfully";
	}

}
