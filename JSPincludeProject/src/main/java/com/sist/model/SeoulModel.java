package com.sist.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;import javax.swing.ToolTipManager;

import com.sist.controller.RequestMapping;
import com.sist.dao.SeoulDAO;
import com.sist.vo.SeoulVO;

public class SeoulModel {
	 @RequestMapping("seoul/location.do")
	   public String seoul_location(HttpServletRequest request,HttpServletResponse response)
	   {   request.setAttribute("main_jsp", "../seoul/location.jsp"); 
	   // value값으로 인클루드할 파일명을 준다
	   // <jsp:include page="${main_jsp }"></jsp:include>
	   		
	   	String strpage=request.getParameter("page");
	   	if (strpage==null) {
			strpage="1";
		}
	   	int curpage=Integer.parseInt(strpage);
	   	final int block=10;
	   	int startpage=((curpage-1)/block*block)+1;
	   	int endpage=((curpage-1)/block*block)+10;
	   	
	   SeoulDAO dao=SeoulDAO.newInstance();
	   int totalpage=dao.totalpage();
	   		List<SeoulVO> list = dao.seoulListData(curpage);
	   		request.setAttribute("list", list);
	   		request.setAttribute("page", curpage);
	   		request.setAttribute("startpage", startpage);
	   		request.setAttribute("endpage", endpage);
	   		request.setAttribute("totalpage", totalpage);
	   	
	      return "../main/main.jsp";
	   }
	 @RequestMapping("seoul/location_detail.do")
	 public String seoul_detail(HttpServletRequest request,HttpServletResponse response)
	   {   request.setAttribute("main_jsp", "../seoul/location_detail.jsp"); 
	   	String sno = request.getParameter("sno");
	   	
	   	SeoulDAO dao=SeoulDAO.newInstance();
	   	SeoulVO vo =dao.detailLocation(Integer.parseInt(sno));
	   	
	   	request.setAttribute("vo", vo);
	   		
	      return "../main/main.jsp";
	   }
}
