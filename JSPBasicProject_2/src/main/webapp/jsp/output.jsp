<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

		//1.한글 =>디코딩을 한다 =>모든 JSP마다 내장객체를 가지고 있다 
		//2.화면 변경 => request가 초기화 =>session/ajax 
		//3.forward (request유지)
		try{
		request.setCharacterEncoding("UTF-8");
		//내장객체
		}
		catch(Exception ex)
		{
			
		}
		String name =request.getParameter("name");
		String sex=request.getParameter("sex"); //radio 는 name이 동일해야 그룹이생성 = >한개만 선택
		String tel1=request.getParameter("tel1");
		String tel2=request.getParameter("tel2");
		String tel = tel1+")"+tel2;
		String introduce=request.getParameter("content");
		String [] hobby=request.getParameterValues("hobby");
		
		
		
		
		
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<%--

jsp주석은 사라진다 
html주석은 남아 있다 
HTMLM+JAVA를 동시에 주석을 설정

=><%=%>
  <% %> ==>MVC에서는 사용하지 않는다 
  		   Spring에서는 MVC만 사용 
  		   =>태그형으로 제작 :JSTL 
  		   <%=%> => ${}
  		   
 =>내장 객체 =>Spring /Spring-boot 
   ***request :JSP마다 request 를 가지고 있다 
   				단점은 화면변경/새로고침=>request 는 초기화
   				=>HttpServletRequest의 객체명
   				=>jsp 페이지로 데이터를 전송시에 데이터 전체를 묶어서 보내준다 
   								  	 ================request
   				=>request는 Map형식으로 되어 있다 
   				(키,값)=>키는 중복이 불가능 하다 
   				<input type =text name="aaa" > = > 못받음
   				<input type =text name="aaa" > => 못받음
   				<input type =text name="aaa" >=> 마지막것만 받음
   								  -----------------키 ,입력값 
   								  getParameter("aaa")
   								  
				=>?name=aaa   = > getParameter("name")
				   ---- ---
				   키    값 = > ?page=1
				   			  ?page= 1 								   			  	  
  							  ====== === 공백 = > 정수로 변환할떄 오류 등 (공백주면안댐)
  				
  				=>a.jsp
  				  =>null
  				  if(a==null)
  				=>a.jsp?name=
  					=>" "공백  
  					if(a.equals(" "))		
  				=>form 태그를 이용해서 전송 : post방식 =>action =() (파일명) 으로 전송 
  				=><a>==>get방식 =>()?  => (파일명) 으로 전송 
  			=============================================			
  						  
   ***response 
   ***session
   application : 업로드   
   ===============
   pageContext =>RequestDispatcher => include,forward 
	<jsp:include>    
   out 		   
   ==================다운로드 
 --%>
<body>
1.****사용자의 IP :<%=request.getRemoteAddr() %><br>
2.서버정보 : <%=request.getServerName() %><br>
3.서버프로토콜:<%=request.getProtocol() %><br>
4.전송방식:<%=request.getMethod() %><br>
5.포트번호:<%=request.getServerPort() %><br>
6.***요청URL:<%=request.getRequestURL() %><br>
7.***요청URI:<%=request.getRequestURI() %><br>
8.***ContextPath:<%=request.getContextPath() %><br> <%--루트 폴더 --%>
9.전송된값 <br>
이름:<%=name %><br>
성별:<%=sex %><br>
전화번호:<%=tel %><br>
소개:<%=introduce %><br>
취미:

<%

try{
	for(int i=0; i<hobby.length;i++){ %>
	<%=hobby[i] %>

	<%
	}%>
<% 	
}catch(Exception ex){ex.printStackTrace();}
%>/


<%--  취미:<%
         try
         {
            out.write("<ul>");
            for(String h:hobby)
            {
               out.write("<li>"+h+"</li>");
            }
            out.write("</ul>");
         }
         catch(Exception ex)
         {
            out.write("취미가 없습니다");
            // <%= 
         }
      %>
      
      --%>


</body>
</html>