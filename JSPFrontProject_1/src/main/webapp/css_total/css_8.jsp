<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body>div{

	width:400px;
	height:100px;
	border:3px solid black;
	position:relative;
	overflow:hidden;
}
.d{
	width:100px;
	height:100px;
	position:absolute;
	z-index: 5;
}

.a{
	background-color:red;
	top:10px;
	right:20px;
	z-index: 10;
}

.b{
	background-color:green;
	top:20px;
	right:30px;
	z-index: 1;
}


.c{
	background-color:blue;
	top:30px;
	right:40px;
}


</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div>
<div class="a d"></div>
<div class="b d"></div>
<div class="c d"></div>
</div>

</body>
</html>