package com.sist.view;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.sist.dao.*;

@WebServlet("/FoodListServlet")
public class ProductDataServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // 사용자가 브라우저를 통해서 요청시에 처리해서 브라우저로 HML을 전송하는 메소드
      // 톰캣에 의해 자동으로 호출
      // 메소드 영역 => JSP => service
      // JSP => 실행 => class변경 => 컴파일해서 실행
      // 전송타입 => html, xml, json
      response.setContentType("text/html;charset=UTF-8");
      //                   text/xml , text/plain
      // html 전송
       PrintWriter out=response.getWriter();
       //             ------------------- 접속한 클라이언트 브라우저
       ProductDAO dao=ProductDAO.newInstance();
       List<ProductVO> list=dao.foodListData(1);
       out.println("<html>");
       out.println("<body>");
       out.println("<center>");
       out.println("<h1>상품top100</h1>");
       out.println("<table border=1 width=800>");
       out.println("<tr>");
       out.println("<th width=15%>이미지</th>");
       out.println("<th width=17%>상품이름</th>");
       out.println("<th width=10%>순위</th>");
       out.println("<th width=8%>평점</th>");
       out.println("<th width=15%>가격</th>");
       out.println("<th width=15%>할인율</th>");
       out.println("<th width=20%>할인가</th>");
  
       out.println("</tr>");
       
       for(ProductVO vo:list)
       {
          out.println("<tr>");
          out.println("<td width=10%><img src="+vo.getP_image()+" width=100 height=50></td>");
          out.println("<td width=15%>"+vo.getProduct_name()+"</td>");
         
          out.println("<td width=10%>"+vo.getProduct_rank()+"</td>");
          out.println("<td width=15%>"+vo.getProduct_grade()+"</td>");
          out.println("<td width=15%>"+vo.getProduct_price()+"</td>");
          out.println("<td width=15%>"+vo.getProduct_sale()+"</td>");
          out.println("<td width=20%>"+vo.getSale_price()+"</td>");
        
          out.println("</tr>");
       }
       out.println("</table>");
       out.println("</center>");
       out.println("</body>");
       out.println("</html>");
       
       
       
   }

}