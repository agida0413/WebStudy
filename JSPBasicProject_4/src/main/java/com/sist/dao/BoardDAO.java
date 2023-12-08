package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
private Connection conn;
private PreparedStatement ps;
private final String url="jdbc:oracle:thin:@localhost:1521:XE";

public BoardDAO(){
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	
}

public void getConnection() {
	try {
		conn=DriverManager.getConnection(url,"hr","happy");
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	
}

public void disConnection() {
	
	try {
		if (ps!=null) {
			ps.close();
		}
		if (conn!=null) {
			conn.close();
		}
		
	} catch (Exception e) {
		// TODO: handle exception
	e.printStackTrace();
	}
}

public List<BoardBean> boardListData(){
	
	List<BoardBean> list=new ArrayList<>();
	try {
		getConnection();
		String sql="SELECT no,subject,name,regdate,hit FROM jspBoard ORDER BY no DESC";
		ps=conn.prepareStatement(sql);
		ResultSet rs =ps.executeQuery();
		
		while(rs.next()){
		BoardBean vo= new BoardBean();
		vo.setNo(rs.getInt(1));
		vo.setSubject(rs.getString(2));
		vo.setName(rs.getString(3));
		vo.setRegdate(rs.getDate(4));
		vo.setHit(rs.getInt(5));
		
			list.add(vo);
		}
				
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally {
		disConnection();
	}
	
	return list;
}

public void boardInsert(BoardBean vo) {
	
	try {
		getConnection();
		String sql="INSERT INTO jspBoard(no,name,subject,content,pwd) "
				+ "values(jb_no_seq.nextval,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getSubject());
			ps.setString(3, vo.getContent());
			ps.setString(4, vo.getPwd());
			
			ps.executeUpdate();
			
	} catch (Exception e) {
		// TODO: handle exception
			e.printStackTrace();
	}
	finally {
		disConnection();
	}
}


}
