<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
div.container{
width:800px;
height:700px;
border:2px solid red;

}
div.header{
width:800px;
height:150px;
border:2px solid green;

}

div.aside{
width:200px;
height:400px;
border:2px solid blue;
float:left;
}

div.section{
width:590px;
height:400px;
border:2px solid magenta;
float:left;

}

div.footer{
width:800px;
height:150px;
border:2px solid black;
clear:both;
}
</style>
</head>
<body>
<div class="container">
<div class="header">
<center>
<%@include file="header.jsp" %>
</center>

</div>
<div class="aside">
<center>
<%@include file="aside.jsp" %>
</center>
</div>

<div class="section">
<center>
<%@include file="header.jsp" %>
</center>
</div>

<div class="footer">
<center>
<%@include file="footer.jsp" %>
</center>
</div>

</div>
</body>
</html>