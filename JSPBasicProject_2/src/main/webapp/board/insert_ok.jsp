<%@page import="com.sist.dao.BoardDAO"%>
<%@page import="com.sist.dao.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
JSP =>1.화면출력  > DOGET
	  2. 요청값을 받아서 처리 => 정려히먄 화면 이동 DOPOST 
	  	=>HTML이 필요 없다 
--%>

<%
	//1.한글디코딩 = > <jsp:useBean> => <jsp:setProperty property="*">
	request.setCharacterEncoding("UTF-8");
	String name=request.getParameter("name");
	String subject=request.getParameter("subject");
	String content=request.getParameter("content");
	String pwd=request.getParameter("pwd");
	
	BoardVO vo=new BoardVO();
	
	vo.setName(name);
	vo.setSubject(subject);
	vo.setContent(content);
	vo.setPwd(pwd);
	
	
	
	//2.오라클 연동
	BoardDAO dao=BoardDAO.newInstance();
	dao.boardInsert(vo);
	
	//3.화면 이동 = >response.sendRedirect() 
	response.sendRedirect("list.jsp");
%>