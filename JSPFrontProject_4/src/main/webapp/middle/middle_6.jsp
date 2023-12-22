<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
=>함수 :코드의 집합 
	  기능 처리 (사용자가 요청=> 행위,브라우저에서만 작동)
	  ======
	  버튼클릭 /마우스 오버 / 변경 / 키보드 처리
	  =호출시에 이벤트 
	  onclick / onmouseover(hover)
	  onmouseout /onchange/onkeydown/onkeyup 
	  	
	  	
	  익명의 함수
	  function(){} =>callback (시스템에 의해 자동호출)
	  		map(function(){})
	   선언적 함수:
	   	= function 함수명(){} =>함수명()
	   	= let func=function(){} = > 이벤트 등록
	   	= let func=()=>{}   이벤트 등록 
	   	
	   
	   함수유형: 리턴형을 기술하지않는다 => 리턴은 가능		
	  	
	  	
	  	
	  	구성요소 
	  	function func_name(){ //선언부 
	  	 	구현부 
	  	 	
	  	
	  	}
	  	=>ES6 권장사항 
	  	 let func_name=function(){}
	  	 let func_name=function(매개변수){}
	  	 
	  	 =>let func_name=function(매개변수){}
	  	 =>let func_name=(매개변수)
	  	 
	  	 
	  	 호출방법 
	  	 function func_name(){}
	  	 let func_name2=function(){}
	  	 
 --%>
 

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
window.onload=function(){
	document.write("<h3>리턴형,매개변수설정</h3>")
	let func2=hello('김용준');
	document.write(func2+"<br>");
	document.write("<hr>");
	document.write("<h3>리턴형만존재</h3>")
	let msg=hello2()
	document.write(msg);
	
hello3();
hello4('김영즌');

}
/* function hello(name) */
 * 
 */
 
 let hello=function(name){
	
	return name+"님 환영합니다...";
}
/* function hello2() */
 * 
 */
 let hello2=function(){
	
	return "hello javascript";
}
/* function hello3() */
 * 
 
 
 */
 let hello3=function(){
	document.write("<br>helloo")
	
}
/* function hello4(name) */
 * 
 
 */
let hello4=function(name){
	document.write("<br>"+name+"님 하이");
	
}
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>