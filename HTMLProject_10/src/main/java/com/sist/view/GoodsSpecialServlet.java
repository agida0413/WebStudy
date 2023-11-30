package com.sist.view;

import java.io.*;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.GoodsDAO;
import com.sist.dao.GoodsVO;

@WebServlet("/GoodsSpecialServlet")
public class GoodsSpecialServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out=response.getWriter();
      // 사용자가 요청한 값을 받는다
      // JSP => page(this)
      String page=request.getParameter("page");
      if(page==null)
         page="1";
      int curpage=Integer.parseInt(page);
      // DAO 연동
      GoodsDAO dao=GoodsDAO.newInstence();
      List<GoodsVO> list=dao.goodsListData(curpage, 2);
      int totalpage=dao.goodsTotalPage(2);
      final int BLOCK=10;
      int startPage=((curpage-1)/BLOCK*BLOCK)+1; // => 1 11 21 ... 
      /*
       *  1 2 ... 10   
       *  |       |
       * startPage  endpage 
       * curpage => 1~10 ==> startpage = 1 유지
       * 
       */
      int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
      // totalpage = 33 ==> endpage = 40 ==> 33까지만 출력
      if(endPage>totalpage)
         endPage=totalpage;
      
      out.write("<html>");
      out.write("<body>");
      out.write("<div class=row>");
      out.write("<h1 class=text-center>특가상품</h1>");
      for(GoodsVO vo:list)
      {
         String s=vo.getName();
         if(s.length()>34)
         {
            s=s.substring(0,34)+"...";
            vo.setName(s);
         }
         else
         {
            vo.setName(s);
         }
      }
      for(GoodsVO vo:list)
      {
          out.write("<div class=\"col-md-3\">"); // 3줄. rowSize=12 로 해놨기 때문
            out.write("<div class=\"thumbnail\">");
            //out.write("<a href=\"/#\">");
            out.write("<a href=#>");
            out.write("<img src="+vo.getPoster()+" alt=\"Lights\" style=\"width:100%\">");
            out.write("<div class=\"caption\">");
            out.write("<p>"+vo.getName()+"</p>");
            out.write("</div>");
            out.write("</a>");
            out.write("</div>");
            out.write("</div>");
      }
         
      out.write("</div>");
      out.write("</body>");
      out.write("</html>");
   }

}