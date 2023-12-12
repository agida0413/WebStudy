package com.sist.model;

import javax.servlet.http.HttpServletRequest;

import com.sist.change.jspChange;

public class MainModel {
public void mainJspChange(HttpServletRequest request) {
	
	String type=request.getParameter("type");
	if(type==null) {
		type="1";
	}
	
	String jsp=jspChange.change(Integer.parseInt(type));
	
	request.setAttribute("main_jsp", jsp);
}
}
