<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="row">
        <c:forEach var="vo" items="${list}">
            <div class="col-md-4">
                <div class="thumbnail">
                    <a href="../seoul/location_detail.do?sno=${vo.no }">
                        <img src="${vo.poster}" style="width:310px; heigth:210px;">
                        <div class="caption">
                            <p>${vo.title}</p>
                        </div>
                    </a>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<center>
 <ul class="pagination">
 <c:if test="${startpage>1 }">
  <li><a href="../seoul/location.do?page=${ startpage - 1}">&lt;</a></li>
  </c:if>
  <c:forEach var="i" begin="${startpage }" end="${endpage }">
  <li><a href="../seoul/location.do?page=${ i}">${i }</a></li>
  </c:forEach>
  <c:if test="${endpage < totalpage }">
  <li><a href="../seoul/location.do?page=${ endpage + 1}">&gt;</a></li>
  </c:if>
</ul> 
</center>
</body>
</html>