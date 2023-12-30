<%@page import="com.sist.dao.foodVO"%>
<%@page import="java.util.List"%>
<%@page import="com.sist.dao.foodDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	
	String strPage=request.getParameter("page");
	if(strPage==null){
		strPage="1";
	}
	int curpage =Integer.parseInt(strPage);
	foodDAO dao=foodDAO.newInstance();
	List<foodVO>list= dao.foodListData(curpage);
	int totalpage= dao.totalPage();
	final int block=10;
	int startPage=((curpage-1)/block*block)+1;
	int endPage=((curpage-1)/block*block)+block;
	if(endPage>totalpage){
		endPage=totalpage;
	}
	request.setAttribute("list",list);
	request.setAttribute("curpage",curpage);
	request.setAttribute("totalpage",totalpage);
	request.setAttribute("startpage",startPage);
	request.setAttribute("endpage",endPage);
%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('.pages').click(function(){
		let page=$(this).text()
		$.ajax({
			type:'post',
			url:'food_list.jsp',
			data:{'page':page},
			success:function(result){
				
				$('.col-sm-8').html(result);
			}
			
		})
	})
	
	$('#start').click(function(){
		
	})
	
	$('#end').click(function(){
		let endpage=$('#end').attr('data-end')
		let totalpage=$('#end').attr('data-total')
		let end=endpage<totalpage?Number(endpage)+1:endpage;
		$.ajax({
			type:'post',
			url:'food_list.jsp',
			data:{'page':end},
			success:function(result){
				
				$('.col-sm-8').html(result);
			}
			
		})
	})
	
	$('#start').click(function(){
		let startpage=$('#start').attr('data-start')
		let totalpage=$('#start').attr('data-total')
		let start=start>1?Number(startpage)-1:startpage;
		$.ajax({
			type:'post',
			url:'food_list.jsp',
			data:{'page':start},
			success:function(result){
				
				$('.col-sm-8').html(result);
			}
			
		})
	})
})
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:forEach var="vo" items="${list }">
		<div class="col-md-3">
    <div class="thumbnail">
      	<a href="#">
        <img src="${vo.poster }" style="width:100%">
        <div class="caption">
          <p>${vo.name }</p>
        </div>
     </a>
    </div>
  </div>
		
		
	</c:forEach>
	<div style="height:20px;"></div>
	<div class="text-center">
		 <ul class="pagination">
  			<li><a href="#" data-start="${startpage }"  data-total="${totalpage }" id="start">&lt;</a></li>
  			<c:forEach var="i" begin="${startpage }" end="${endpage }">
  			
 		 <li ${curpage==i?"class=active":"" }><a href="#" class="pages">${i }</a></li>
 		 </c:forEach>
		  <li><a href="#" data-end="${endpage }"  data-total="${totalpage }" id="end">&gt;</a></li>
		  
		</ul> 
	</div>

</body>
</html>