<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="../layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row1{
   margin: 0px auto;
   width: 800px;
}
</style>
</head>
<body>
   <div class="wrapper row3">
      <main class="container clear">
         <h2 class="sectiontitle">MyBatis를 이용한 자료실</h2>
         <div class="row row1" style="height: 500px;">
            <table class="table">
               <tr>
                  <td><a href="../databoard/insert.do"
                     class="btn btn-sm btn-danger">등록</a></td>
               </tr>
            </table>
            <table class="table">
               <tr>
                  <th class="text-center" width=10%>번호</th>
                  <th class="text-center" width=50%>제목</th>
                  <th class="text-center" width=10%>이름</th>
                  <th class="text-center" width=20%>작성일</th>
                  <th class="text-center" width=10%>조회수</th>
               </tr>
             
               <c:forEach var="vo" items="${list }">
                  <tr>
                     <td class="text-center" width=10%>${vo.no }</td>
                     <td width=50%><a href="../databoard/detail.do?no=${vo.no}">${vo.subject }</a></td>
                    
                     <td class="text-center" width=10%>${vo.name }</td>
                     <td class="text-center" width=20%>${vo.dbday }</td>
                     <td class="text-center" width=10%>${vo.hit }</td>
                  </tr>
                  
               </c:forEach>
               <tr>
               <td colspan="5" class="text-center">
               <a href="#" class="btn btn-danger btn-sm">이전</a>
               ${curpage } page / ${totalpage } pages
               <a href="#" class="btn btn-danger btn-sm">다음</a>
               </td>
               </tr>
            </table>
         </div>
      </main>
   </div>
</body>
</html>