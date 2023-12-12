<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*,com.sist.vo.*,java.util.*"%>
    <jsp:useBean id="dao" class="com.sist.dao.FoodDAO"></jsp:useBean>
    
    <%--
    fs=all&mode=2&ss=
    
    ss= 가 있으면 공백
    ss= 자체가 없으면 null값 =>오류
     --%>
     
     <%
    int totalpage=0;
     String fs=request.getParameter("fs");
     String ss=request.getParameter("ss");
     String strpage =request.getParameter("page");
     if(strpage==null){
    	 strpage="1";
     }
     int curpage=Integer.parseInt(strpage);
     
     List<FoodVO>list=new ArrayList<FoodVO>();
     
     if(ss==null || ss.equals("")){
    	 
    	 fs="all";
     }
     if(fs.equals("all")){
    	list=dao.foodfindAllData(curpage, ss);
    	totalpage= dao.foodFindAlltotalpage(ss);
    	
     }
     else{
    	 list=dao.foodfindData(curpage, fs, ss);
     	totalpage=dao.foodFindtotalpage(fs, ss);
     }
     
     final int block=10;
     int startpage=((curpage-1)/block*block)+1;
     int endpage=((curpage-1)/block*block)+block;
     
     if(endpage>totalpage){
    	 endpage=totalpage;
     }
     
     %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="wrapper row3">
  <main class="container clear"> 
    <!-- main body --> 
    <!-- ################################################################################################ -->
    <div class="content"> 
      <!-- ################################################################################################ -->
      <div id="gallery">
        <figure>
          <header class="heading">
          <form method="post" action="../main/main.jsp" class="inline"> <%--메인에서 리퀘스트를 받고 include 된 jsp에게 공유를 하므로 setcharencode를 이 페이지 에설정하면 깨짐 --%>
          <select name="fs">
          <option value="all" <%=fs.equals("all")?"selected:":"" %>>전체</option>
          <option value="name" <%=fs.equals("name")?"selected":"" %>>업체명</option>
          <option value="address"<%=fs.equals("address")?"selected":"" %>>주소</option>
          </select>
          <input type=hidden name=mode value=2>
          <input type="text" name=ss value="<%=ss==null?"":ss %>" size=15>
          <button>검색</button>
          </form>
          </header>
          <ul class="nospace clear">
          	<%
          	for(int i=0;i<list.size();i++){
          		FoodVO vo=list.get(i);
          	%>
            <li class="one_quarter <%=i%4==0?"first":""%>"><a href="#"><img src="https://www.menupan.com/<%=vo.getPoster() %>" title="<%=vo.getName() %>" alt=""></a></li>
         	
         	<%
          	}
         	%>
          
          </ul>
          <figcaption>Gallery Description Goes Here</figcaption>
        </figure>
      </div>
      <!-- ################################################################################################ --> 
      <!-- ################################################################################################ -->
      <nav class="pagination">
        <ul>
        <%
        	if(startpage>1){
        %>
          <li><a href="../main/main.jsp?mode=2&page=<%=startpage-1 %>&ss=<%=ss%>&fs=<%=fs%>">&laquo; Previous</a></li>
          <%
          }
        %>
       
        
        <%for(int i=startpage;i<=endpage;i++){ %>
          <li><a href="../main/main.jsp?mode=2&page=<%=i%>&ss=<%=ss%>&fs=<%=fs%>"><%=i %></a></li>
          <%} %>
         <%if(endpage<totalpage){ %>
          <li><a href="../main/main.jsp?mode=2&page=<%=endpage+1%>&ss=<%=ss%>&fs=<%=fs%>">Next &raquo;</a></li>
          <%} %>
        </ul>
      </nav>
      <!-- ################################################################################################ --> 
    </div>
    <!-- ################################################################################################ --> 
    <!-- / main body -->
    <div class="clear"></div>
  </main>
</div>
</body>
</html>