<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.bean.*"%>
<%
request.setCharacterEncoding("UTF-8");

%>
<%-- StudentBean bean=new StrudentBean() :메모리할당  --%>
<jsp:useBean id="bean" class="com.sist.bean.StudentBean">
<jsp:setProperty name="bean" property="*"/><%-- property="*"을 사용할경우 데이터 넘겨주는 쪽의 naem=" 값 " 과 baen의 변수이름이 같아야 자동으로 매핑을 해준다 --%>
<%--
sb.setHakbun(Integer.parseInt(hakbun));
sb.setName(name);
sb.setKor(Integer.parseInt(kor));
sb.setEng(Integer.parseInt(eng));
sb.setMath(Integer.parseInt(math));

 --%>
</jsp:useBean>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>학생 정보 </h1>
학번:<%=bean.getHakbun() %><br>
이름:<%=bean.getName() %><br>
국어점수:<%=bean.getKor() %>점<br>
영어점수:<%=bean.getEng() %>점<br>
수학점수:<%=bean.getMath() %>점
</body>
</html>