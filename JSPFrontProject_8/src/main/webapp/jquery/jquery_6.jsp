<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#box{
width:100px;
height:100px;
background-color:red;
}
#box.hover{
background-color:blue;
border-radius:50px;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#box').hover(function(){
		$('#box').addClass('hover')
	},function(){
		$('#box').removeClass('hover')
	})
})

</script>
</head>
<body>
<div id="box"></div>
</body>
</html>