<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.dao.*" import="java.net.*"%>
<jsp:useBean id="dao" class="com.sist.dao.FoodDAO"/>
<%--
   쿠키 => 상태의 지속
          === state : 데이터 관리 => react/vue => 변수
                                     |
                                   props/state
          === 저장 공간 : 브라우저 (로컬)
              ======= 메소드 제공 
                      ========
                      = 1. 저장
                           new Cookie(key,값) (Map형식)
                           =================
                            : 단점 = 문자열만 저장이 가능
                            : 키는 중복이 불가능하다
                           *** Cookie는 반드시 해당 사용자 브라우저로 전송
                               => response는 한개 일만 수행이 가능!
                               => Cookie 전송하느냐 / HTML 전송하느냐 => 한개만 선택
                                  => JSP파일에서
                                  => JSP는 두개가 필요하다 (하나는 쿠키, 하나는 화면 보내기)
                                  => detail.jsp : HTML
                                  => before.jsp : 쿠키
                        2. 읽기 
                           request.getCookies() = Cookie[]
                        3. 삭제
                           = setMaxAge(0) => 저장 기간을 없애서 삭제시키는 방식
                        4. 저장기간 설정
                           = setMaxAge(초단위)
                        5. key 읽기 => getName()
                           값 읽기 => getValue()
                        6. 저장 경로 설정 
 --%>
<%
   request.setCharacterEncoding("UTF-8");
   String fd=request.getParameter("fd");
   String ss=request.getParameter("ss");
   
   if(fd==null)
      fd="address";
   if(ss==null)
      ss="마포";
   
   String strPage=request.getParameter("page");
   if(strPage==null)
      strPage="1";
   int curpage=Integer.parseInt(strPage);
   List<FoodVO> list=dao.foodListData(curpage, fd, ss);
   for(FoodVO vo:list)
   {
      String s=vo.getName();
      if(s.length()>13)
      {
         s=s.substring(0,12)+"...";
         vo.setName(s);
      }
      vo.setName(s);
   }
   int totalpage=dao.foodTotalPage(fd, ss);
   
   Cookie[] cookies=request.getCookies();
   List<FoodVO>clist=new ArrayList();
   if(cookies!=null){
	 for(int i=cookies.length-1;i>=0;i--){
			//food_
		 if(cookies[i].getName().startsWith("food_")){
			 
			 String fno=cookies[i].getValue();
			 FoodVO vo=dao.foodDetailData(Integer.parseInt((fno)));
			 
			 clist.add(vo);
			 
		 }
		 
	 }
	   
	   
   }
   
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
   margin-top: 50px;
}
.row{
   margin: 0px auto;
   width: 960px;
}
</style>
</head>
<body>
  <div class="container">
   <div class="row">
    <form method=post action="find.jsp">
     <select name=fd class="input-sm">
      <option value="address" <%=fd.equals("address")?"selected":"" %>>주소검색</option>
      <option value="name" <%=fd.equals("name")?"selected":"" %>>업체명검색</option>
     </select>
     <input type="text" name=ss size=20 class="input-sm"
      value="<%=ss %>"
     >
     <button class="btn btn-sm btn-danger">검색</button>
    </form>
   </div>
   <div style="height: 30px"></div>
   <div class="row">
    <%
      for(FoodVO vo:list)
      {
    %>
        <div class="col-md-3">
          <div class="thumbnail">
           <a href="detail_before.jsp?fno=<%=vo.getFno()%>&fd=<%=fd%>&ss=<%=URLEncoder.encode(ss,"UTF-8")%>">
           <img src="https://www.menupan.com<%=vo.getPoster() %>" title="<%=vo.getAddress() %>" style="width:100%">
           <div class="caption">
           <p><%=vo.getName() %></p>
           </div>
           </a>
          </div>
         </div>
    <%
      }
    %>
   </div>
   <div style="height: 20px"></div>
   <div class="row">
     <div class="text-center">
      <a href="find.jsp?fd=<%=fd %>&ss=<%=ss %>&page=<%=curpage>1?curpage-1:curpage %>" class="btn btn-sm btn-success">이전</a>
      <%=curpage %> page / <%=totalpage %> pages
      <a href="find.jsp?fd=<%=fd %>&ss=<%=ss %>&page=<%=curpage<totalpage?curpage+1:curpage %>" class="btn btn-sm btn-info">다음</a>
     </div>
   </div>
   <div style="height: 20px"></div>
   <div class="row">
   <h3>최신 방문 맛집</h3>
   <a href="cookie_all_delete.jsp" class="btn btn-sm btn-warning">전체삭제</a>
   
   <hr>
    <form method=post action="cookie_delete.jsp">
   <%
   int i=0;
   for(FoodVO vo : clist){
		if(i>8) break;   
   	
   %>
  
   <input type=checkbox name="del" value="<%=vo.getFno() %>">
   <img src="https://www.menupan.com<%=vo.getPoster()%>" style="width:100px;height:100px">
   
   <%
   
   i++;
   }
   %>
   <p>
   <button class="btn btn-sm btn-danger">삭제</button>
   </form>
   </div>
  </div>
</body>
</html>