<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){

	$('img').attr("src","https://m.moviechart.co.kr/thumb?width=348&height=500&m_code=20235596&source=http://moviechart.co.kr/assets/upload/movie/231205112721_9506.jpg")	
	let img = $('img').attr('src')
	console.log(img)
	let src=$('script').attr('type')
	alert(src)
})
</script>
<body>
<img src="" style="width:400px;">
</body>
</html>