package com.nt.service;

public class CarShowRoom {
	public String sale(String model,float price,String executive) {
		if(model.equalsIgnoreCase("baleno")||model.equalsIgnoreCase("briza"))
		return model+" car price is "+price+" has purchased by "+executive+" executive";
		else {
			return model+" not available";
			
		}
	}

}
