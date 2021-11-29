package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.CarShowRoom;

public class BeforeAdviceTest {

	public static void main(String[] args) {
		//create ioc container
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get traget Class refecrnce to generate inMemory proxy class as sub class of targt class
		CarShowRoom car=ctx.getBean("service",CarShowRoom.class);
		//call business method
		System.out.println(car.sale("baleno",1200000.f, "Finch"));

	}

}
