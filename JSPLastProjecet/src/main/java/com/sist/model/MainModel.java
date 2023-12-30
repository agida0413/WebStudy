package com.sist.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.RequestMapping;
import com.sist.dao.FoodDAO;
import com.sist.vo.FoodVO;

public class MainModel {
@RequestMapping("main/main.do")

   public String main_main(HttpServletRequest request, HttpServletResponse response)
   {	
	
	FoodDAO dao=FoodDAO.newInstance();
	List<FoodVO>alist =dao.foodBestListData("한식");
	List<FoodVO>blist =dao.foodBestListData("양식");
	List<FoodVO>clist =dao.foodBestListData("중식");
	List<FoodVO>dlist =dao.foodBestListData("일식");
	
	request.setAttribute("alist", alist);
	

	request.setAttribute("blist", blist);
	

	request.setAttribute("clist", clist);
	

	request.setAttribute("dlist", dlist);
	

      request.setAttribute("main_jsp", "../main/home.jsp");
      return "../main/main.jsp";
   }

}