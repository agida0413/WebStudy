<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

String fno=request.getParameter("fno");
String fd=request.getParameter("fd");
String ss=request.getParameter("ss");

//1.쿠키생성
Cookie cookie =new Cookie("food_"+fno,fno);
//2저장경로 설정
cookie.setPath("/");
//3.저장기간
cookie.setMaxAge(60*60*24);

//4.쿠키 브라우저 전송
response.addCookie(cookie);

//5.상세보기로 이동
response.sendRedirect("detail.jsp?fno="+fno+"&fd="+fd+"&ss="+URLEncoder.encode(ss,"UTF-8"));
//sendRedirect 는 get방식 =>요청값 전송시 반드시?
		

		
%>