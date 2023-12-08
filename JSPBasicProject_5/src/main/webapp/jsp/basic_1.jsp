<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- 
    	JSP => JAVA SERVER PAGE 
    			서버에서 실행하는 자바 파일
    	======================== 교재 생략 : 자바 ,데이터베이스 ,제공하는 예제			
    	1.지시자
    		<%@ page %>
    			contentType :브라우저에 전송 = > 파일형식 
    				=text/html;Charset=utf-8
    				=text/xml;Charset=utf-8
    				=text/plain;Charset=utf-8
    			====>html,xml,json	
    			===>자바 변경 ==>response.setContentType()
    			errorpage :error가 날경우에 지정된 파일로 이동 
    			isErrorpage:true/false => exception 객체 사용시 
    			import :외부 클래스를 읽어 올때 => 여러번 사용이 가능 
    				=>JSP에서만 MVC에서는 사용하지 않는다
    			buffer : 8kb ==>증가 2배권장
    								====
    								
    		<%@ taglib%>
    			JSTL /EL
    	2.스크립트
    	<% %> :일반자바 (main 안에 소스코딩)
    	<%=%> :데이터 출력 
    			=>${}
    			=>가급적이면 <%%>를 제거 
    			
    	jsp < =========> jsp
    					  |
    					 DAO ==>Model 1방식 =>재사용이 없다
    					 
    	jsp ===controller ===model===dao
    						 =======자바(재사용성)
    						 Model 2방식 =>현재 98%
    	===>단점 :Controller에 집중 
    			============분할 =>Domain방식 ==>MSA 					 				 
    					 			
    	
    	3.내장 객체(MVC에서도 사용)
    	request,response,session application out pageContext  
    	4.JSP액션태그
    	<jsp:usebean>
    	<jsp:setProperty>
    	<jsp:include>
    	=============================
    	5.EL
    	6.JSTL
    	7.MVC 
    	============================
    	8.XML
    	9.어노테이션
    	
    			 
    	
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