package com.nt.service;

public final class  BankAccountImpl implements IBankAccount {
	
	@Override
	public Float calculateIntrest(float amt,float intrest,int time) {
		return (amt*intrest*time)/100;
	}

}
