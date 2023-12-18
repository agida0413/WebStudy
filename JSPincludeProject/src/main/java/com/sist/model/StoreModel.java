package com.sist.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.RequestMapping;
import com.sist.dao.GoodsDAO;
import com.sist.dao.SeoulDAO;
import com.sist.vo.GoodsVO;
import com.sist.vo.SeoulVO;

public class StoreModel {
	 @RequestMapping("store/all.do")
	 public String store_all(HttpServletRequest request,HttpServletResponse response)
	   {   
		 String page= request.getParameter("page");
		 
		 if(page==null) {
			 page="1";
		 }
		 int curpage=Integer.parseInt(page);
		 GoodsDAO dao=GoodsDAO.newInstance();
		 
		 List<GoodsVO>list=dao.goodAllListData(curpage);
		 //all.jsp= > 데이터베이스 결과값을 전송
		 int toatlpage=dao.totalpage();
		 request.setAttribute("store_jsp","../store/all.jsp");
	   request.setAttribute("main_jsp", "../store/store_main.jsp");
	   request.setAttribute("totalpage",toatlpage);
	   request.setAttribute("curpage", curpage);
	   request.setAttribute("list", list);
	   
	      return "../main/main.jsp";
	   }
	 
	 @RequestMapping("store/best.do")
	 public String best_all(HttpServletRequest request,HttpServletResponse response)
	   {   
		 request.setAttribute("store_jsp","../store/best.jsp");
	   request.setAttribute("main_jsp", "../store/store_main.jsp");
	   		
	      return "../main/main.jsp";
	   }
	 
	 @RequestMapping("store/new.do")
	 public String new_all(HttpServletRequest request,HttpServletResponse response)
	   {   
		 request.setAttribute("store_jsp","../store/new.jsp");
	   request.setAttribute("main_jsp", "../store/store_main.jsp");
	   		
	      return "../main/main.jsp";
	   }
	 
	 @RequestMapping("store/sp.do")
	 public String sp_all(HttpServletRequest request,HttpServletResponse response)
	   {   
		 request.setAttribute("store_jsp","../store/sp.jsp");
	   request.setAttribute("main_jsp", "../store/store_main.jsp");
	   		
	      return "../main/main.jsp";
	   }
}
