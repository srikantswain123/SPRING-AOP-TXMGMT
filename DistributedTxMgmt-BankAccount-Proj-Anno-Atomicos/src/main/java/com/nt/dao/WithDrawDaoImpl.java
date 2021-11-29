package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("withdrawDao")
public class WithDrawDaoImpl implements IWithDrawDao {
	
	private static final String WITHDRAW_QUERY="UPDATE DTX_BANK SET BALANCE=BALANCE-? WHERE ACNO=?";
	@Autowired
	@Qualifier("orajt")
	private JdbcTemplate oraTemp;

	@Override
	public int Withdraw(long srcAcno, double amount) {
		int count=oraTemp.update(WITHDRAW_QUERY, amount,srcAcno);
		return count;
	}

}
