package com.sist.controller;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.sist.model.*;
@WebServlet("*.do")
// list.do (목록 찾기) / update.do / delete.do / insert.do
/*
 * 
 * 1.관련된 클래스가 여러개 있따 = > 인터페이스 통합
 * 2.조건문 없이 사용 = > map 
 * 3.미리 클래스 메모리 할당 
 * 미리 주소값을 할당했기때문에 자동으로 싱글턴 
 * 4.Model을 찾는 경우에는 값을 넘기는게 아니라 url 주소를 이용해서 찾는다 
 * 5.구분 
 * 	 ==
 * 	 request를 jsp로 전송 ==>forward 
 * 	 request를 초기화 하고 jsp만 호출  =>redirect
 * 	 jsp를 변경하지 않고 전송 (데이텀나 전송) =>Ajax(void)
 * 	
 *  => Controller 
 *          1. 요청을 받는다 
 *        2. Model을 찾는다
 *        3. Model의 메소드를 호출한다 => request
 *        4. request를 JSP로 전송한다 
 *     => Model
 *          1. 요청값을 받는다 => 매개변수 request
 *          2. 요청처리 => DAO
 *        3. 결과값을 request에 담아준다 => set.attribute
 *     => View
 *          1. Controller에서 보내준 request를 출력
 * 

 */
public class Controller extends HttpServlet {
   private static final long serialVersionUID = 1L;
   private Map clsMap=new HashMap();
   public void init(ServletConfig config) throws ServletException {
      clsMap.put("list", new ListModel());
      clsMap.put("insert", new InsertModel());
      clsMap.put("update", new UpdateModel());
      clsMap.put("delete", new DeleteModel());
   }

   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      String cmd=request.getRequestURI();
      /*
         /JSPMVCProject_2/list.do
         ================
          ContextPath
      */
      System.out.println("cmd=>1:"+cmd);
      cmd=cmd.substring(request.getContextPath().length()+1,
            cmd.lastIndexOf("."));
      System.out.println("cmd=>2:"+cmd);
      
      Model model=(Model)clsMap.get(cmd);
      System.out.println(model);
      String jsp=model.excute(request);
      
      RequestDispatcher rd= request.getRequestDispatcher(jsp);
      rd.forward(request, response);
      
   }

}



