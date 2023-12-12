<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <%--
    
    	prefix="c" => <c: 
    	prefix="core" = > <core:
    	JSTL 자바의 제어문 => 태그로 만들어져 있다
    	====
    	 core : 변수 설정 , 제어문 , URL (화면이동)
    	 	<c:set>: 변수 설정 
    	 	<c:set var="today" value="2023-12-11"/>
    	 	=>request.setAttribute("today","2023-12-11");
    	 	<c:redirect url="a.jsp">
    	 	=>response.sendredirect("a.jsp");
    	 	<c:if> if =>다중조건문 /else 문장이 없다 
    	 	<c:foreach> for
    	 	<c:choose> switch = > 다중조건 
    	 	<c:forTokens>
    	 	
    	 	format / xml/sql/fn = > String 메소드
    	 	=====			 ===
    	 	
    	 	
     --%>
     <%
     List<String>list=new ArrayList<String>();
     list.add("홍길동");
     list.add("심청이");
     list.add("박문수");
     list.add("이순신");
     list.add("강감찬");
     %>
     <c:set var="list" value="<%=list %>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>java:for</h1>



<%
for(int i = 1; i<=10; i++){
%>

<%=i %>

<%
}
%>

<h1>jstl :for</h1>
<%-- step = 1이면 생략가능 --%>
<%-- step은 -1는 사용불가 --%>
<c:forEach var="i" begin="1" end="10" step="1">
${i}&nbsp;
</c:forEach>

<h1>jstl:foreach</h1>
<c:forEach var="aaa" items="${list }">
<li>${aaa }</li>
</c:forEach>
</body>
</html>