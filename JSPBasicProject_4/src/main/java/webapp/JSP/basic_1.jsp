<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%--
    211page=>자바빈즈 => 데이터를 모아서 브라우저로 한번에 전송 
    		========
    			JSP : Bean, MyBatis :DTO ,Spring ;VO
    		|액션태그 
    		 <jsp:useBean>:객체생성
    		 => BoardVO vo=new BoardVO();
    		 	<jsp:Bean id="vo" class="BoardVO">
    		 <jsp:setProperty>
    		 	set메소드 호출 
    		 	<jsp:setProperty name="vo" property="name" value="홍길동">
    		 		=>vo.setName("홍길동")
    		 <jsp:getProperty>
    		 	get메소드 호출
    		 	<jsp:geteProperty name="vo" property="name">
    		 	=>  <%= vo.getName()%>
    		 		
    		 <jsp:include>
    		 pageContext.include()
    		 ***<jsp:include page=""> 특정위치에 다른 jsp를 첨부
    		 <jsp:param>:팝업 
    		 데이터 전송 
    =>213page :자바빈즈 만들기 
     	=>1)데이터를 저장할 변수 설정 =>캡슐화 => private설정 
     		private으로 설정이 되면 다른 클래스에서 사용이 불가능 
     		=> 변수의 기능을 부여하는 메소드를 만든다 
     			======= 메모리 저장/메모리 읽기 
     			 		===============
     			 		setter  getter 
     			 		
     	  2) getter/setter
     	  	=>set변수명()=>첫자는 대문자
     	  	  setNmae()
     	  	=>get변수명()=>첫자는 대문자
     	  	  getName()
     	  	=> boolean이면 
     	  		priavate boolean login;
     	  		=>setter : isLogin()
     	  		=>getter : getLoggin() 
     	  	=>여기서 사용하는 모든 getter/setter 는 
     	  	  다른 클래스와 호환 =>public 
     	  	=>데이터 보호 / =>메소드를 이용해서 처리 
     	  	=>jsp=>MemberBean ,BoardBean  	   		 				 
    		 
     --%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>