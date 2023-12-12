package com.sist.model;
// 요청을 받아서 처리후에 결과값을 request/session에 담아서 JSP로 보내주는 역할
/*
 *        request
 *    JSP => Model => DAO
 *        <=       <=
 *        request => 결과값을 추가해서 전송
 *    =======================================< Call By Reference
 */
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.sist.vo.*;
import com.sist.dao.*;
public class GoodsModel {
   public void goodsListData(HttpServletRequest request)
   {
      // type , page => <% %>
      String type=request.getParameter("type");
      if(type==null)
         type="1";
      String page=request.getParameter("page");
      if(page==null)
         page="1";
      // 페이지 지정
      int curpage=Integer.parseInt(page);
      // 페이지에 해당되는 목록
      GoodsDAO dao=new GoodsDAO();
      List<GoodsVO> list=
            dao.goodsAllListData(curpage, Integer.parseInt(type));
      int totalpage=dao.goodsTotalpage(Integer.parseInt(type));
      
      final int BLOCK=10;
      int startPage=((curpage-1)/BLOCK*BLOCK)+1;
      int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
      
      if(endPage>totalpage)
         endPage=totalpage;
      
      // JSP에서 출력할 데이터를 전송
      request.setAttribute("list", list);
      request.setAttribute("curpage", curpage);
      request.setAttribute("totalPage", totalpage);
      request.setAttribute("startPage", startPage);
      request.setAttribute("endPage", endPage);
      request.setAttribute("type", type);

      
      
   }
   
   public void goodsDetailData(HttpServletRequest request) {
	   //요청값을 받는다.
	   //요청에 해당하는 데이터 베이스 값읽기
	   //request에 담아준다
	   //detail.jsp
	   String table=request.getParameter("table");
	   String no=request.getParameter("no");
	   String type=request.getParameter("type");
	   
	   GoodsDAO dao=new GoodsDAO();
	   GoodsVO vo=dao.goodsDetailData(Integer.parseInt(table), Integer.parseInt(no));
	   request.setAttribute("type", table);
	   request.setAttribute("no", no);
	   request.setAttribute("mode", type);
	   request.setAttribute("vo", vo);
	   
	   
	   
	   
	   
   }
}