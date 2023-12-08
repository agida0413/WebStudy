<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" buffer="16kb"%>
    <%--
    	내장객체 = > 미리 객체를 생성한 후에 사용이 가능하게 만든것 
    	======
    	1.객체명
    	2.클래스 
    	3.용도
    	4.주요메소드 
    	-----------------------------------
    	request 
    	클래스명  HttpServletRequest 
    	용도	   클라이언트의 요청 값을 묶어서 저장하고 있다 
    			클라이언트의 정보 :IP
    			세션이나 쿠키 생성
    			한글변환(디코딩)
    	주요메소드  getParameter(key명) =>단일값 받기 
    			getParameterValues(key명) =>다중값 받기 (체크박스)
    			setCharacterEncoding()=>한글변환 
    			======================= 전송:인코딩 수신 :디코딩
    			getRemoteAddr() => ip
    			getCookie(),getSession()
    			========================
    			서버정보 
    			getRequestURL
    			getRequesetURI
    			getContextPath
    			추가정보
    			setAttribute()
    			getAttribute()
    			====================
    			
    			Model 2
    			JSP<=>JSP
    			
    			MIDDLE
    			MV = > JAVA/html =>el/jstl
    			
    			Model 2 
    			MVC => Spring 
    			
    			response
    			==============================================
    			클래스명 HttpServletResponse
    			용도 : HTML, cookie 전송 
    				화면 변경 
    				헤더 작성 
    			주요메소드 :response.setContentType("")
    					=>text/html,xml,plain
    					addCookie() =>해당브라우저로 전송 
    					sendRedirect(파일명)=>GET방식 
    					setHeader()=>다운로드 
    			==========================================
    			out :JspWriter 
    				=>출력버퍼 (HTML을 출력해서 저장하는 공간)
    						===========================
    						|요창한 브라우저에서 공간의 html을 읽어서 출력 
    						|자동으로 비워준다 =>브라우저 한개당 한개만 생성 
    						|기본8kb
    				=>화면출력 
    					println()/print() 
    				=>버퍼의 크기 
    					getBufferSize()
    				=>남아 있는 버퍼 확인 
    				getRemaining()
    				=><%=%> =>${}
    				
    				=> 한번사용 => 다운로드 
    								
    			application
    			pageContext
    			exception
    			config
    			page					
    			
    	
    	
     --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>out:JspWriter:버퍼관리</h1>




1.전체 버퍼크기<%=out.getBufferSize() %><br>
2.남은 버퍼크기:<%=out.getRemaining() %><br>
3.사용중인 버퍼크기:<%=out.getBufferSize()-out.getRemaining() %><br>
4.&lt;%=%&gt; 대체:out.println()/out.write()
	=>복잡한 HTML을 만들경우
	<br>
	<%
	out.println("<h1>OUT객체</h1>");
	out.write("<h1>OUT객체</h1>");
	
	%>
</body>
</html>