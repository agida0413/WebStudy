package com.sist.model;

import javax.servlet.http.HttpServletRequest;

public class InsertModel implements Model{

	@Override
	public String excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		request.setAttribute("msg", "게시판 추가");
		return "view/insert.jsp";
	}

}
