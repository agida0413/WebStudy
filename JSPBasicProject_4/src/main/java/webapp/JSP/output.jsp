<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.bean.*"%>
<%
request.setCharacterEncoding("UTF-8");

String hakbun=request.getParameter("hakbun");
String name=request.getParameter("name");
String kor=request.getParameter("kor");
String eng=request.getParameter("eng");
String math=request.getParameter("math");

StudentBean sb=new StudentBean();
sb.setHakbun(Integer.parseInt(hakbun));
sb.setName(name);
sb.setKor(Integer.parseInt(kor));
sb.setEng(Integer.parseInt(eng));
sb.setMath(Integer.parseInt(math));

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>학생 정보 </h1>
학번:<%=sb.getHakbun() %><br>
이름:<%=sb.getName() %><br>
국어점수:<%=sb.getKor() %>점<br>
영어점수:<%=sb.getEng() %>점<br>
수학점수:<%=sb.getMath() %>점

</body>
</html>