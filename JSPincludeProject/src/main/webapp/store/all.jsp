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
<div class="row">

<h1 class="text-center">전체상품</h1>
<c:forEach var="vo" items="${list}" >
 <div class="col-md-4">
    <div class="thumbnail">
           <a href="#">
        <img src="${vo.goods_poster}" title="${goods_name }" >
        <div class="caption">
          <p>${vo.goods_price }</p>
        </div>
           </a>
            </div>
  </div>

</c:forEach>
</div>
<div style="height:20px"></div>
<div class="row">
<div class="text-center">
<a href="all.do?page=${curpage>1?curpage-1:curpage }" class="btn btn-sm btn-primary">이전</a>
${curpage }page / ${totalpage }page
<a href="all.do?page=${curpage<totalpage?curpage+1:curpage}" class="btn btn-sm btn-primary">다음</a>
</div>
</div>
</body>
</html>