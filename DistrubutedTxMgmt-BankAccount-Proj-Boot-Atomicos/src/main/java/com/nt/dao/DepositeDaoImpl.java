package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("depositeDao")
public class DepositeDaoImpl implements IDepositeDao {
	
	private static final String DEPOSITE_QUERY="UPDATE DTX_BANK SET BALANCE=BALANCE+? WHERE ACNO=?";
	
	@Autowired
	@Qualifier("mysqljt")
	private JdbcTemplate mySqlTemp;
	

	@Override
	public int deposite(long destAcno, double amount) {
		int count=mySqlTemp.update(DEPOSITE_QUERY, amount,destAcno);
		return count;
	}

}
