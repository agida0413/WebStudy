package com.sist.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sist.dao.BoardDAO;
import com.sist.vo.boardVO;

public class DetailModel implements Model {

	@Override
	public String handleReuquest(HttpServletRequest request) {
		// TODO Auto-generated method stub
	String no = request.getParameter("no");
	BoardDAO dao=BoardDAO.newInstance();
	
	boardVO vo= dao.boardDetail(Integer.parseInt(no));
	request.setAttribute("vo", vo);
		
		
		return "board/detail.jsp";
	}

}
