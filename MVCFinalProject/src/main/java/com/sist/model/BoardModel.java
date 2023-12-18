package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.*;

public class BoardModel {
	
	
	@RequestMapping("board/list.do")
	public String list(HttpServletRequest request,HttpServletResponse response) {
		
		request.setAttribute("msg", "게시판목록");
		return "../board/list.jsp";
		
	}
	
}
