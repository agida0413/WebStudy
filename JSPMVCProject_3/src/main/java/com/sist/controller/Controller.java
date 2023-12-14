package com.sist.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;

import com.sist.model.Model;

/**
 * Servlet implementation class Controller
 */
@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map map= new HashMap<>();

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		String path="C:\\WebDev\\WebStudy\\JSPMVCProject_3\\src\\main\\webapp\\WEB-INF\\application.xml";
		try {
			DocumentBuilderFactory dbf =DocumentBuilderFactory.newInstance();
			DocumentBuilder db =dbf.newDocumentBuilder();
			//파서기
			Document doc =db.parse(new File(path));
			
			//1.루트 (beans) = > 테이블명
			Element beans=doc.getDocumentElement();
			System.out.println(beans.getTagName());
			//2.같은 태그를 묶어서 제어 
			NodeList list= beans.getElementsByTagName("bean");
			for(int i=0; i<list.getLength();i++) {
				Element bean=(Element)list.item(i);
				String id=bean.getAttribute("id");
				String cls = bean.getAttribute("class");
				System.out.println(id);
				System.out.println(cls);
				//메모리 할당 = > map에 저장 
				
				Class clsName=Class.forName(cls);
				Object obj = clsName.getDeclaredConstructor().newInstance();
				System.out.println(obj);
				map.put(id, obj);
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//주문받기시작
		String cmd=request.getRequestURI();
		cmd=cmd.substring(request.getContextPath().length()+1,cmd.lastIndexOf("."));
		System.out.println(cmd);
		Model model=(Model)map.get(cmd);
		String jsp=model.handleReuquest(request);
		if(jsp.startsWith("redirect:")) {
			jsp=jsp.substring(jsp.indexOf(":")+1);
			response.sendRedirect(jsp);
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher(jsp);
			rd.forward(request, response);
		}
	}

}
