<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%--
    1.내장객체 얻기
    	getRequest() , getResponse() ,getOur()
    	getSession ,getPage(),getExection()
    	application = > getServletContext()
    	=>사용 빈도가 거의 없다 (99.999999)
    	
    	request.getParameter()
    	pageCotext.getRequest().getParameter()
    	
    2.웹흐름제어
    	include(),forward() =>파일마다 request공유를 한다 
    	pageContext.include() ==>x 
    		=><jsp:include>
    		=>
    		1. <%@ include file=""> :정적
    			=>file에는 반드시 file명을 설정한다
    			menu/footer
    		2.<jsp:include page="">	:동적
    			=>내용 출력 시에 변경 
    			page=변수명 
    		
    		=>jsp안에 특정위치에 다른 jsp를 포함
    		a.jsp 
    		<html>
    			<body>
    			<%
    			int a=10;
    			%>
    			<h1><%= a%> </h1>
    			</body>
    				</html>		
    			========================
    	
    		<html>
    		<body>
    		<h1>10<h1>
    		</body>
    		</html>
    		==============================
    		b.jsp 
    		<html>
    		<body>
    			<%
    			int a=100;
    			%>
    			<h1><%=a%></h1>
    			=============================
    			<%@ include file="a.jsp">
    				<html>
    			<body>
    			<%
    			int a=10;
    			%>
    			<h1><%= a%> </h1>
    			</body>
    				</html> 변수가 같은게 있어 오류발생 소스를 합쳐서 한번에 컴파일
    			====================================================
    			
    			<jsp:include page="a.jsp">	 같은 변수가 있어도 오류 x 따로따로 컴파일(a.jsp,b.jsp) 	
    			
    				========================
    	
    		<html>
    		<body>
    		<h1>10<h1>
    		</body>
    		</html>
    		============================== 
    				
    		</body>
    		</html>
    		====================================
    		
    		</html>			
    		<html>
    		<body>
    		<h1>100<h1>
    		</body>
    		</html>
    	
    
    --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>