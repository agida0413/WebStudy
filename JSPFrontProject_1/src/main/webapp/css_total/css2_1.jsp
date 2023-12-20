<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">


div{
border:1px red solid;
}
div img {
width:120px;
height:150px;
}
div img#main{
width:800px;
height:500px;
}
div.a{
float:left;
margin-right: 10px;
}
div.b{
width:800px;
height:500px;
clear:both;

}



</style>

<script type="text/javascript" src="http://code.jquery.com/jquery/js"></script>
<script type="text/javascript">
$(function(){
	$('.img').hover(function(){
		${this}
		
	});
	
});
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="a"><img src="https://img.cgv.co.kr/Movie/Thumbnail/Poster/000087/87907/87907_320.jpg" class="img"></div>
<div class="a"><img src="https://img.cgv.co.kr/Movie/Thumbnail/Poster/000087/87784/87784_320.jpg" class="img"></div>
<div class="a"><img src="https://img.cgv.co.kr/Movie/Thumbnail/Poster/000087/87554/87554_320.jpg" class="img"></div>
<div class="a"><img src="https://img.cgv.co.kr/Movie/Thumbnail/Poster/000087/87716/87716_320.jpg" class="img"></div>
<div class="a"><img src="https://img.cgv.co.kr/Movie/Thumbnail/Poster/000087/87873/87873_320.jpg" class="img"></div>
<div class="a"><img src="https://img.cgv.co.kr/Movie/Thumbnail/Poster/000087/87757/87757_320.jpg" class="img"></div>
<div class="b"><img src="https://img.cgv.co.kr/Movie/Thumbnail/Poster/000087/87888/87888_320.jpg" id="main"></div>
</body>
</html>