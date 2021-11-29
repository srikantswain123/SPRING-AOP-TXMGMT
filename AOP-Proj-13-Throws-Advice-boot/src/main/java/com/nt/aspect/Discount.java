package com.nt.aspect;

import java.io.FileWriter;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component("discount")
@Aspect
public class Discount {
	@AfterReturning(pointcut = "execution(float com.nt.service.Shopping.*(..))",returning = "amount")
	public void cupon(JoinPoint jp,float amount)throws Throwable {
		System.out.println("after advice execute");
		String msg="";
		if(amount<10000)
			msg="you have 5% discount on next shooping";
		else if(amount<20000)
			msg="you have 10% discount on next shooping";
		else if(amount<30000)
			msg="you have 10% discount on next shooping";
		FileWriter writer=new FileWriter("D:/cupon.txt");
		writer.write(msg);
		writer.flush();
		writer.close();
	}//method

}//class
