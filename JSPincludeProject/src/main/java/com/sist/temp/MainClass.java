package com.sist.temp;

import java.lang.reflect.Method;

class A{
	public void aaa() {
		System.out.println("A:aaa() Call...");
		
	}
	public void bbb() {
		System.out.println("A:bbb() Call...");
		
	}
	public void ccc() {
		System.out.println("A:ccc() Call...");
		
	}
}
public class MainClass {

	public static void main(String[] args) {
//		A a=new A();
//		a.aaa();
//		a.bbb();
//		a.ccc();
		
		try {
			Class cls =Class.forName("com.sist.temp.A");
			Object obj=cls.getDeclaredConstructor().newInstance();
			A a=(A)obj;
//			a.aaa();
//			a.bbb();
//			a.ccc();
//			
			Method[] methods = cls.getDeclaredMethods();
			for (Method method : methods) {
				method.invoke(obj);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
