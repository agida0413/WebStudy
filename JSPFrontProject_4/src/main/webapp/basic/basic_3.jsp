<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
window.onload=function(){
	let kor=90
	let eng=85
	let math=78
	
	let total=kor+eng+math
	let avg=total/3
	
	document.write("국어:"+kor+"<br><hr>")
	document.write("영어:"+eng+"<br><hr>")
	document.write("수학:"+math+"<br><hr>")
	document.write("총점:"+total+"<br><hr>")
	document.write("평점:"+Math.round(avg)+"<br>")
	
	
	let score ='A';
	
	if(avg>90){
		score='A';
	}
	else if(avg>=80){
		score='B';
	}
	else if(avg>=70){
		score='C';
	}
	else if(avg>=60){
		score='D';
	}
	else{
		score='제명';
	}
	document.write("학점:"+score)
}
</script>
<body>

</body>
</html>