package com.sist.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sist.dao.BoardDAO;
import com.sist.vo.boardVO;
import java.util.*;

public class ListModel implements Model {

	@Override
	public String handleReuquest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		//사용자의 요청값
		
		String page=request.getParameter("page");
		BoardDAO dao=BoardDAO.newInstance();
		
		if(page==null) {
			page="1";
		}
		int curpage=Integer.parseInt(page);
		int totalpage=dao.boardTotalpage();
		
		List<boardVO>list=dao.boardListData(curpage);
		
		//jsp로 보낼값
		request.setAttribute("list", list);
		request.setAttribute("curpage",curpage);
		request.setAttribute("totalpage", totalpage);
		
		
		return "board/list.jsp";
	}
	
	

}
