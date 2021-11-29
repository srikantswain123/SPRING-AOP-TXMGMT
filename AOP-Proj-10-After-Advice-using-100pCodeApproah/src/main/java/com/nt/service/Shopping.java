package com.nt.service;

import org.springframework.stereotype.Service;

@Service("shopping")
public class Shopping {
	public float shop(String[] items,float[] amt) {
		float balance=0.0f;
		for(float f:amt)
			balance=balance+f;
		return balance;
	}

}
