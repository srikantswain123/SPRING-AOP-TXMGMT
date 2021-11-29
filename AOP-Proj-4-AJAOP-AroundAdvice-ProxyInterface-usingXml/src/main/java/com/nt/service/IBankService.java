package com.nt.service;

public interface IBankService {
	public float simpleIntrest(float amt,float intrest,int month);
	public float compoundIntrest(float amt,float intrest,int month);
}
