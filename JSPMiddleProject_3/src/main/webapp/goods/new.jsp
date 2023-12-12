<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.model.*"%>
    <jsp:useBean id="model" class="com.sist.model.GoodsModel"></jsp:useBean>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
    model.goodsListData(request);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="row">
<h1 class="text-center">신상품</h1>
<c:forEach var="vo" items="${list}" >
 <div class="col-md-3">
    <div class="thumbnail">
        <a href="main.jsp?type=5&no=${vo.no }&table=${type}">
        <img src="${vo.goods_poster}" title="${goods_name }" >
        <div class="caption">
          <p>${vo.goods_price }</p>
        </div>
           </a>
            </div>
  </div>

</c:forEach>
</div>
<div style="height:10px"></div>
<div class="row">
   <div class="text-center">
    <ul class="pagination">
       
      <c:if test="${startPage>1 }"> 
       <li><a href="main.jsp?type=${type }&page=${startPage-1}">&lt;</a></li>
       </c:if>
       <c:forEach var="i" begin="${startPage }" end="${endPage }">
       <li ${curpage==i?"class=active":"" }><a href="main.jsp?type=${type }&page=${i}">${i }</a></li>
       </c:forEach>
       <c:if test="${endPage<totalPage }">
       <li><a href="main.jsp?type=${type }&page=${endPage+1}">&gt;</a></li>
       </c:if>
     </ul>
   </div>
</div>
</body>
</html>