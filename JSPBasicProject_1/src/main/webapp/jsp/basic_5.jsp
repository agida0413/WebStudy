<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- 
    	for = > foreach 구문 
    	=>if ~else (129page) 
    	
    
    --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
	1~100까지의 합 , 짝수의 합 ,홀수의 합 
	//활성화 ,비활성화 
 --%>
 
 <% int sum=0,even=0,odd=0;
    for(int i =0; i<=100;i++){
    	sum+=i;
    	if(i%2==0){
    		even+=i;
    	}
    	else
    	odd+=i;
    
    }
	%>
	
	<h3>1~100까지의 총합<%=sum %></h3>
	<h3>1~100까지의 짝수총합<%=even %></h3>
	<h3>1~100까지의 홀수총합<%=odd %></h3>
</body>
</html>