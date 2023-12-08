<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <% //실행 = >사이트주소 = >마지막에 있는 파일이 request
    String id =request.getParameter("id");
    String pwd=request.getParameter("pwd");
    String mode=request.getParameter("mode");
    
   if(Integer.parseInt(mode)==1){
	   response.sendRedirect("e.jsp");
	   
   }
   else{
	   pageContext.forward("e.jsp");
	   //<jsp:forward page=""> jsp액션태그 
			   //mvc구조 
   }
    
    
    %>
    