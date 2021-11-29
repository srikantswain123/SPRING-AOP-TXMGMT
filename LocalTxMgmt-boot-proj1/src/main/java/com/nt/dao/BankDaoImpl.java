package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("bankDao")
public class BankDaoImpl implements IBankDao {
	private static final String WITHDRAW_QUERY="UPDATE BANKACCOUNT SET BALANCE=BALANCE-? WHERE ACNO=?";
	private static final String DEPOSITE_QUERY="UPDATE BANKACCOUNT SET BALANCE=BALANCE+? WHERE ACNO=?";
	
	@Autowired(required = true)
	private JdbcTemplate jt;


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
