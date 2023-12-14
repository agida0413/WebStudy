package com.sist.model;

import javax.servlet.http.HttpServletRequest;

public class InsertModel implements Model {

	@Override
	public String handleReuquest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		//화면이동
		return "board/insert.jsp";	}

}
