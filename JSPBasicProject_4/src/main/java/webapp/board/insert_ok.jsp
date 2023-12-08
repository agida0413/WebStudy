<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    request.setCharacterEncoding("UTF-8");
    %>
    <jsp:useBean id="dao" class="com.sist.dao.BoardDAO"/>
    <jsp:useBean id="bean" class="com.sist.dao.BoardBean">
    <jsp:setProperty name="bean" property="*"/>
    </jsp:useBean>
    
    <%
    dao.boardInsert(bean);
    response.sendRedirect("list.jsp");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>