package com.sist.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import com.sist.dbcp.CreateDBCPconnection;


public class foodDAO {
private Connection conn;
private PreparedStatement ps;
private CreateDBCPconnection dbconn= new CreateDBCPconnection();
private static foodDAO dao;

//싱글턴 

public static foodDAO newInstance() {
	if(dao==null) {
		dao=new foodDAO();
	}
	return dao;
}

public List<foodVO> foodListData(int page){
	List<foodVO> list=new ArrayList<>();
	try {
		conn=dbconn.getConnection();
		String sql="SELECT name,poster,num "
					+"FROM (SELECT name,poster,ROWNUM as num "
					+"FROM (SELECT name,poster "
					+"FROM food_menu_house ORDER BY fno ASC)) "
					+"where NUM BETWEEN ? AND ? ";
		ps=conn.prepareStatement(sql);
		int rowsize=12;
		int start=(rowsize*page)-(rowsize-1);
		int end=rowsize*page;
		
		ps.setInt(1, start);
		ps.setInt(2, end);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			foodVO vo =new foodVO();
			vo.setName(rs.getString(1));
			vo.setPoster("https://www.menupan.com"+rs.getString(2));
			list.add(vo);
		}
	} catch (Exception e) {
		e.printStackTrace();
		// TODO: handle exception
	}
	finally {
		dbconn.disConnection(conn, ps);
	}
	
	return list;
}

public int totalPage() {
	int total=0;
	try {
		conn=dbconn.getConnection();
		String sql ="SELECT CEIL(COUNT(*)/12.0) FROM food_menu_house";
		ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		rs.next();
		total=rs.getInt(1);
		rs.close();
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	finally {
		dbconn.disConnection(conn, ps);
	}
	
	return total;
}


}
