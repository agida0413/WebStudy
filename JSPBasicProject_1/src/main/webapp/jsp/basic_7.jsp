<%@page import="org.apache.taglibs.standard.tag.rt.core.ForEachTag"%>
<%@page import="org.apache.taglibs.standard.tag.common.core.ForEachSupport"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%--
    139page
    =지시자
    page :jsp파일에 대한 정보
    =>jsp의 시작점 
    =>1.contentType = 실행시에 변경될 파일형식 
    	=>자바로 변경 : response.setContentType()
    	=>  html= text/html;charset=UTF-8 = > 지정안하면 한글 꺠짐
    						===========
    						charset-ISO-8859-1 (디폴트 1바이트 ) 
    	=>  xml=text/xma;charSet=UTF-8
    	=>	json =text/plain;charSet=UTF-8
 		
 		=>브라우저에 알려 준다
 		=>page안에서 1번만 사용이 가능 
 		
 		   	   
      2.import => 외부라이브러리 첨부 
      			  java.lang, javax.http.servlet 
      			  ==========================생략이 가능
      => 사용형식 
      <%@ page import = "java.util.*,java.io.*"%>
      <%@ page import = "java.util.*"%>
      <%@ page import = "java.io.*"%>			  
      
      
      3.buffer =>html을 저장하는 메모리 공간
      			=>8kb (default)
      			=>html이 출력을 할 떄 용량이 부족시에는 증가 
      			  buffer="16kb"=> 출력스트림
      4.errorPage =>에러시에 호출되는 파일 
      
   taglib: 태그로 자바 기본 문법을 제공 = > jstl/el
   include:jsp안에 다른 jsp를 첨부
   <%@ 지시자명 속성="값"%>
   
    
     --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


</body>
</html>