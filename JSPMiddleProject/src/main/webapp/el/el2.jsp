<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<!DOCTYPE html>



<%--
 581page
 기본객체(내장 객체)
 =>***requestScope/ ***sessionScope/applicationScope/ 
 =>param / pageContext
 
 EL은 자바변수를 출력하는 것이 아니다 
 ==request,session 에 저장된 데이터를 출력 
 
 
 --%>
 <%
 String name ="홍길동";
 request.setAttribute("name", name);
 session.setAttribute("name1","이이이이"); // xxxxScope 생략시  둘다이름이 같으면 생략시 request 가 우선순위, 이름이 다르면 둘다 생략가능 
 //param => getparameter()
 //param.key =>param.name
 //applicationScope => reqalpath 
 /*
 ${} = > 출력물 (request , session에 담겨 출력을 요청시에만 사용 ) 
 
 */
 %>
 
 
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--이름은 ${requestScope.name } 입니다.<br>

이름은 ${name }입니다
<br>

이름은<%=request.getAttribute("name") %>입니다.
세션이름은 ${name1 }입니다.
 --%>

<jsp:useBean id="model" class="com.sist.dao.StudentModel"></jsp:useBean>
<%

StudentVO vo= model.studentDetailData();
request.setAttribute("vo", vo);

%>
학번 :${vo.hakbun }<br>
이름: ${vo.getName() }<br>
국어:${vo.getKor() }<br>
영어:${vo.eng }<br>
수학:${vo.math }<br>

</body>
</html>