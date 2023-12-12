package com.sist.dao;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
public class EmpModel {

	
	public void empListData(HttpServletRequest request) {
		EmpDAO dao = new EmpDAO();
		List<EmpVO> list=dao.enpListData();
		request.setAttribute("list", list);
	}
}
