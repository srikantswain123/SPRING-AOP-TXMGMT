package com.nt.Aspect;

import java.io.FileWriter;
import java.time.LocalDateTime;

import org.aspectj.lang.JoinPoint;

public class TestDriveAspect {
	
	
	/*public void testDrive(JoinPoint jp)throws Throwable {
		System.out.println("Secondary class");
		Object args[]=jp.getArgs();
		if (!(args[0].toString().equalsIgnoreCase("baleno")||args[0].toString().equalsIgnoreCase("briza")))
			return;
		FileWriter writer=new FileWriter("D:/auditLog.txt",true);
		writer.write(args[0]+" car purchased by "+args[2]+" executive "+LocalDateTime.now()+" \n");
		writer.flush();
		writer.close();
	}*/
	/*public void testDrive(JoinPoint jp,String model,float price,String executive)throws Throwable {
		System.out.println("Secondary class");
		Object args[]=jp.getArgs();
		if (!(model.toString().equalsIgnoreCase("baleno")||model.toString().equalsIgnoreCase("briza")))
			return;
		FileWriter writer=new FileWriter("D:/auditLog.txt",true);
		writer.write(model+" car purchased by "+executive+" executive "+LocalDateTime.now()+" \n");
		writer.flush();
		writer.close();
	}*/
	
	public void testDrive(String model,float price,String executive)throws Throwable {
		System.out.println("Secondary class");
		if (!(model.toString().equalsIgnoreCase("baleno")||model.toString().equalsIgnoreCase("briza")))
			return;
		FileWriter writer=new FileWriter("D:/auditLog.txt",true);
		writer.write(model+" car purchased by "+executive+" executive "+LocalDateTime.now()+" \n");
		writer.flush();
		writer.close();
	}

}
