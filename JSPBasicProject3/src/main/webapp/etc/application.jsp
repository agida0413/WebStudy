<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%--
    application=>ServletContext 
    ===========서버관리 (서버에 대한 정보 , 로그에 대한 정보)
    서버 
    =getServerInfo()
    =getMajorVersion()
    =getMinorversion()
    1.8
    - -
    
    =log => web.xml 
    =getRealPath() => 업로드 
    
    
     --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>application:ServletContext</h1>
1.서버정보 :<%=application.getServerInfo()%><br>
2.버전정보 :<%=application.getMajorVersion()%><br>
3.마이너 버전: <%=application.getMinorVersion()%><br>
4.실제경로명 :<%=application.getRealPath("/")%>
<%
String driver=application.getInitParameter("driver");
//MAP (key=>value)
//KEY <param-name> value=<param-value>
String url=application.getInitParameter("url");
String username=application.getInitParameter("username");
String password=application.getInitParameter("password");

application.log("driver:"+driver);
application.log("url:"+url);
application.log("username:"+username);
application.log("password:"+password);
%>

</body>
</html>