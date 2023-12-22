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
	//do~while
	
	for(let i=0; i<=10; i++){
		
		document.write(i+"<br><hr>");
	}
	
	
	document.write("<h3>break</h3>");
	
	for(let i=1;i<=10;i++){
		
		if(i===5)break;
		document.write("i="+i+"<br><hr>")
	}
	}
	
	document.write("<hr>")
	for(let i=1; i<=10; i++){
		if(i===5) continue;
		
		document.write("i="+i+"con");
		
	}


</script>
<body>

<h1>연습</h1>
<div class="container">
<div class="row">
<table class="table">
<tr>
<td><td>
<td><td>
</tr>

</table>
</div>
</div>

</body>
</html>