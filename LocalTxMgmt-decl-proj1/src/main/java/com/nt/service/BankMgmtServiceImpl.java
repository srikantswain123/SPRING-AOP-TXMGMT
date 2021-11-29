package com.nt.service;

import com.nt.dao.IBankDao;

public class BankMgmtServiceImpl implements IBankMgmtService {
	//inject dao
	private IBankDao dao;
	

	public BankMgmtServiceImpl(IBankDao dao) {
		this.dao = dao;
	}


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
