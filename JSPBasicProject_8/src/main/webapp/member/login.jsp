<%@page import="com.sist.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="dao" class="com.sist.dao.MemberDAO"></jsp:useBean>
<%
request.setCharacterEncoding("UTF-8");
String id=request.getParameter("id");
String pwd=request.getParameter("pwd");

MemberVO vo= dao.isLoggin(id, pwd);

if(vo.getMsg().equals("NOID")){
	%>
	
	<script>alert("아이디가 존재하지않습니다.")
		history.back();
	</script>
	<%
	
}






else if(vo.getMsg().equals("NOPWD")){
%>

	
<script>alert("비밀번호가 틀렸습니다.")
		history.back();
	</script>


<%	
}





else if(vo.getMsg().equals("OK")){
	session.setAttribute("id",vo.getId());
	session.setAttribute("name", vo.getName());
	session.setAttribute("admin", vo.getAdmin());
	
	response.sendRedirect("../main/main.jsp");
}

%>