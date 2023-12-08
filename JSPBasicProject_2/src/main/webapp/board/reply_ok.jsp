<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<%

	request.setCharacterEncoding("UTF-8");
	String name=request.getParameter("name");
	String subject=request.getParameter("subject");
	String content=request.getParameter("content");
	String pwd=request.getParameter("pwd");
	//hidden
	String pno= request.getParameter("pno");
	String curpage=request.getParameter("page");
		
	BoardVO vo=new BoardVO();
	
	vo.setName(name);
	vo.setSubject(subject);
	vo.setContent(content);
	vo.setPwd(pwd);
	
	
	
	//2.오라클 연동
	BoardDAO dao=BoardDAO.newInstance();
	
	dao.bordReplyInsert(Integer.parseInt(pno), vo);
	
	
	
	//3.화면 이동 = >response.sendRedirect() 
	response.sendRedirect("list.jsp?page="+curpage);
	
%>
    
    