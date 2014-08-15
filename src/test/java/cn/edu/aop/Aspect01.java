package cn.edu.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class Aspect01 {
	
	public void pointCut1(){
		System.out.println(".............i'm the point1");
	}
	
	public void around(ProceedingJoinPoint jp){
		Object[] args =jp.getArgs();
		System.out.println("------------args---------");
		for(Object o:args){
			System.out.println(o);
		}
		System.out.println("------------args---------");
		try {
			jp.proceed(args);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
