package com.nt.dao;

public interface IBankDao {
	public int withdraw(long acno,double amt);
	public int deposite(long acno,double amt);

}
