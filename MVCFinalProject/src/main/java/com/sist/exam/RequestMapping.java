package com.sist.exam;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
/*
 * 
 * 구분자
 * =>찾기 = > 인덱스 ㅡ
 * =>if문과 동일하다
 * =>어노테이션= > 위에
 * 
 * class A
 * {
 * @RequestMapping("a") 요청값이 a 라면 = >aaa()
 * aaa()
 * 
 * @RequestMapping("b")
 * bbb()
 * @RequestMapping("c")
 * ccc()
 * }
 */
@Retention(RUNTIME)
//저장기간
/*
 * runtime 
 * ======= 프로그램 종료시까지 유지
 * source
 * class
 * ======= 컴파일 후에 자동으로 메모리가 해제 
 */
@Target(METHOD)
//찾기 = > 구분자 
/*
 * TYPE, methd, field ,parameter ,constructor
 * 
 * @= > type 
 * 	class A 
 * {
 * 	@=>field
 * B b= new B();
 * @=> method
 * 	public void display(){}
 * @ = > CONSTRUCTOR
 * A()
 * 
 * public boid aaa(@=>PARAMTER B b)
 * }
 *  @ReuquestMapping("경로")
 */


public @interface RequestMapping {
public String value();
}
