package com.sist.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;import java.util.concurrent.atomic.LongAccumulator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.RequestMapping;

public class ReserveModel {
@RequestMapping("reserve/date.do")
public String reserve_date(HttpServletRequest request,HttpServletResponse response) {
	
	String today= new SimpleDateFormat("yyyy-M-d").format(new Date());
	StringTokenizer st=new StringTokenizer(today,"-");
	int year=Integer.parseInt(st.nextToken());
	int month=Integer.parseInt(st.nextToken());
	int day=Integer.parseInt(st.nextToken());
	String [] strweek= {"일","월","화","수","목","금","토"};
	
	Calendar cal=Calendar.getInstance();
	cal.set(Calendar.YEAR, year);
	cal.set(Calendar.MONTH, month-1);
	cal.set(Calendar.DATE, 1);
	int week=cal.get(Calendar.DAY_OF_WEEK);
	week=week-1;
	
	int lastday=cal.getActualMaximum(Calendar.DATE);
	request.setAttribute("main_jsp", "../reserve/date.jsp");
	request.setAttribute("month", month);
	request.setAttribute("day", day);
	request.setAttribute("year",year);
	request.setAttribute("strweek", strweek);
	request.setAttribute("week", week);
	request.setAttribute("lastday", lastday);
	return "../main/main.jsp";
}
}
