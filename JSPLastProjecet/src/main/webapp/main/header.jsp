<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="wrapper row1">
  <header id="header" class="clear"> 
    <div id="logo" class="fl_left">
      <h1><a href="index.html">Gravity</a></h1>
    </div>
    <div class="fl_right">
    <c:if test="${sessionSCope.id==null }">
      <ul class="inline">
        <li><i class="fa fa-user"></i><input type="text" class="input-sm" id="id"></li>
        <li><i class="fa fa-key"></i> <input type="password" class="input-sm" id="pwd"></li>
        <li><input type="button" class="btn btn-sm btn-danger" id="logBtn" value="로그인" style="height:28px;"> </li>
        
      </ul>
      </c:if>
      <c:if test="${sessionScope.id!=null }">
      <ul class="inline">
        <li><i class="fa fa-user"></i>${sessionScope.name }님(${sessionScope.admin=='y'?'관린자':'일반' }) 로그인중입니다.</li>

        <li><input type="button" class="btn btn-sm btn-danger" id="logoutBtn" value="로그아웃" style="height:28px;"> </li>
        
      </ul>
      </c:if>
    </div>	
    </header>
</div>
<div class="wrapper row2">
  <nav id="mainav" class="clear"> 
    <ul class="clear">
      <li class="active"><a href="../main/main.do">Ȩ</a></li>
      <li><a class="drop" href="#">회원</a>
       <c:if test="${sessionScope.id==null }"> <%-- 로그인이 안됐을 때 --%>
        <ul>
          <li><a href="../member/join.do">회원가입</a></li>
          <li><a href="pages/full-width.html">아이디 찾기</a></li>
          <li><a href="pages/sidebar-left.html">비밀번호 찾기</a></li>
        </ul>
        </c:if>
       <c:if test="${sessionScope.id!=null }"> <%-- 로그인이 됐을 때 --%>
        <ul>
          <li><a href="pages/gallery.html">회원수정</a></li>
          <li><a href="pages/full-width.html">회원탈퇴</a></li>
        </ul>
       </c:if>
      </li>
      <li><a class="drop" href="#">맛집</a>
        <ul>
          <li><a href="pages/gallery.html">전체 맛집</a></li>
          <li><a href="pages/full-width.html">지역별 맛집 찾기</a></li>
          <c:if test="${sessionScope.id!=null }">
           <li><a href="pages/sidebar-left.html">맛집 예약</a></li>
          </c:if>
        </ul>
       
      </li>
      <li><a class="drop" href="#">레시피</a>
        <ul>
          <li><a href="pages/gallery.html">레시피</a></li>
          <li><a href="pages/full-width.html">쉐프</a></li>
          <c:if test="${sessionScope.id!=null }">
           <li><a href="pages/sidebar-left.html">레시피 만들기</a></li>
          </c:if>
        </ul>
      </li>
      <li><a class="drop" href="#">서울 여행</a>
        <ul>
          <li><a href="pages/gallery.html">명소</a></li>
          <li><a href="pages/full-width.html">자연&관광</a></li>
          <li><a href="pages/sidebar-left.html">쇼핑</a></li>
          <li><a href="pages/sidebar-left.html">호텔</a></li>
          <li><a href="pages/sidebar-left.html">날씨</a></li>
        </ul>
      </li>
      <li><a href="#">스토어</a></li>
      <li><a class="drop" href="#">커뮤니티</a>
        <ul>
          <li><a href="pages/gallery.html">자유게시판</a></li>
          <li><a href="pages/full-width.html">공지사항</a></li>
          <li><a href="pages/sidebar-left.html">자료실</a></li>
        </ul>
      </li>
      <c:if test="${sessionScope.id!=null }">
      <c:if test="${sessionScope.admin=='n'}">
      <li><a href="#">마이페이지</a></li>
      </c:if>
       <c:if test="${sessionScope.admin=='y'}">
      <li><a href="#">관리자페이지</a></li>
      </c:if>
      </c:if>
    </ul>
    </nav>
</div>
</body>
</html>