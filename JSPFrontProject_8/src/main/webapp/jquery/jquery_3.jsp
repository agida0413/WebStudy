<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	let input=$('input').val()
	alert(input)
	$('input').val('아이디가없습니다.')
})
</script>

</head>
<body>
<div><h1>Hello Jquery</h1></div>
<input type="text" size="20" value="hello">
</body>
</html>