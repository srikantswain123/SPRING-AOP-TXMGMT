package com.nt.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class BankDaoImpl implements IBankDao {
	private static final String WITHDRAW_QUERY="UPDATE BANKACCOUNT SET BALANCE=BALANCE-? WHERE ACNO=?";
	private static final String DEPOSITE_QUERY="UPDATE BANKACCOUNT SET BALANCE=BALANCE+? WHERE ACNO=?";
	
	private JdbcTemplate jt;
	

	public BankDaoImpl(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public int withdraw(long acno, double amt) {
		int count=jt.update(WITHDRAW_QUERY, amt,acno);
		return count;
	}

	@Override
	public int deposite(long acno, double amt) {
		int count=jt.update(DEPOSITE_QUERY, amt,acno);
		return count;
	}

}
