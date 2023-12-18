package com.sist.exam;

import java.lang.reflect.Method;
import java.util.Scanner;import javax.swing.text.html.HTMLFrameHyperlinkEvent;

class Model {
	@RequestMapping("a")
	public void aaa() {
		System.out.println("Model:aaa()");
	}
	@RequestMapping("b")
	public void bbb() {
		System.out.println("Model:bbb()");
	}
	@RequestMapping("c")
	public void ccc() {
		System.out.println("Model:ccc()");
	}
	@RequestMapping("d")
	public void ddd() {
		System.out.println("Model:ddd()");
	}
}
public class MainClass {
		public static void main(String[] args) {
			Scanner scanner =new Scanner(System.in);
			System.out.println("검색어 입력:;");
			String fd= scanner.next();
			
//			Model model= new Model();
//			if(fd.equals("aaa")) {
//				
//				model.aaa();
//			}
//			else if (fd.equals("bbb")) {
//				model.bbb();
//			}
//			else if (fd.equals("ccc")) {
//				model.ccc();
//			}
			try {
				Class clsName =Class.forName("com.sist.exam.Model");
				//클래스 정보를 읽어온다
				Object obj=clsName.getDeclaredConstructor().newInstance();
				Method[] methods =clsName.getDeclaredMethods();
				
				for (Method method : methods) {
					System.out.println(method.getName());
					RequestMapping rm=method.getAnnotation(RequestMapping.class);
							
							if(rm.value().equals(fd)) {
								method.invoke(obj, null);
								break;
							}
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
					
		}
	

}
