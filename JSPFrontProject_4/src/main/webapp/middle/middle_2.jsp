<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%--
    	=> 객체모델 : 태그를 읽어오는방법
    	document.querySelector(CSS선택자)
    	document.getEelementById()
    	
    	=>내장객체 : String ,Math ,Date =>함수 
    	=>브라우저 내장객체:window ,document ,history,location
    	====================================================
    	|
    	라이브러리 변경 = > Jquery ==>동적(Ajax)
    	
    	단일값 저장 = > 변수 let 변수명 =값(값에 따라 자동으로 데이터형이 결정)
    	다중 값 저장 = > 
    	=======
    	1.배열[] => 자바와 다른점 :데이터형이 혼합이 가능 
     	
     	2.객체 {} = > {키:값
     --%>
     
     <!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
window.onload=function(){
	
	let arr=["홍길동",20,'A','영업',3500]
	console.log(arr)
	console.log("arr="+typeof arr)
	
	for(let data of arr){
		document.write(data+"<br>")	
	}
	
	
	document.write("<hr>")
	
	document.write("<h3>객체표현법:(JSON)</h3>")
	
	let sawon={sabun:1,name:"홍길동",dept:"개발부",pay:3500}
	
	document.write("사번:"+sawon.sabun+" 이름:"+sawon.name+" 부서:"+sawon.dept+" 연봉:"+sawon.pay);
	document.write("<hr>")
	
	document.write("<h3>객체표현법:(JSON)2</h3>")
	
	document.write("사번:"+sawon['sabun']+" 이름:"+sawon['name']+" 부서:"+sawon['dept']+" 연봉:"+sawon['pay']);
	document.write("<hr>")
	
	document.write("<h3>객체표현법:(JSON)2</h3>")
	for(let key in sawon){
	document.write(key+":"+sawon[key]+"<br>")	
	}
	
	
	
	
}
	
	
	
	

</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>