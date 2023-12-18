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
<div class="container">
  <h2>${vo.title }</h2>
  <p></p>            
  <table class="table" style="width:100%; heigth:100%; margin:0px auto;">
    
    <tbody>
      <tr  >
        <td rowspan=5 style="width:40%"><img src="${vo.poster }"> </td>
        
      </tr>
      <tr>
        <th style="width:30%">이름</th>
        <td style="width:30%">${vo.title }</td>
      
      </tr>
      <tr>
        <th style="width:30%">주소</th>
        <td style="width:30%">${vo.address }</td>
      
      </tr>
       <tr>
        <th style="width:30%">내용</th>
        <td style="width:30%">${vo.msg}</td>
      
      </tr>
      
        <tr>
    
        <td style="width:30%; text-align:center;"><button >목록</button></td>
      
      </tr>
      
    </tbody>
  </table>
</div>
</body>
</html>