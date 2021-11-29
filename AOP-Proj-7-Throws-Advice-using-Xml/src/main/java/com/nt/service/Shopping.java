package com.nt.service;

import java.util.Arrays;

public class Shopping {
	public float shop(String[] items,float[] amt) {
		boolean flag=false;
		if(items==null || amt==null )
			flag=true;
		
		float balance=0.0f;
		for(float f:amt) {
			if(f<=0) {
				flag=true;
				break;
			}
			balance=balance+f;
		}
			if(flag==true)
				throw new IllegalArgumentException("Invalid Inputs");
		
		return balance;
	}

}
