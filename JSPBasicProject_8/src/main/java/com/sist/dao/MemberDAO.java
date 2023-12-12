package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sist.dbcp.CreateDBCPconnection;
import com.sist.vo.MemberVO;

public class MemberDAO {
private Connection conn;
private PreparedStatement ps;
private static MemberDAO dao;
private CreateDBCPconnection dbconn=new CreateDBCPconnection();

//1.로그인 

public MemberVO isLoggin(String id,String pwd) {
	//Spring에서 변경 =>암호화/복호화 
	MemberVO vo=new MemberVO();
	
	try {
	conn=dbconn.getConnection();
	//id 존재여부 확인 
	//pwd 확인
	String sql="SELECT COUNT(*) FROM jspMember WHERE id=?";
	ps=conn.prepareStatement(sql);
	ps.setString(1, id);
	
	ResultSet rs=ps.executeQuery();
	rs.next();
	int count=rs.getInt(1);
	rs.close();
	
	if(count==0) {
		vo.setMsg("NOID");
	}
	else {
		
		sql= "SELECT pwd FROM jspMember WHERE id=?";
		ps=conn.prepareStatement(sql);
		ps.setString(1, id);
		
		rs=ps.executeQuery();
		rs.next();
		String db_pwd=rs.getString(1);
		rs.close();
		
		if(db_pwd.equals(pwd)) {
			vo.setMsg("OK");
			sql="select id,name,admin FROM jspMember WHERE id=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, id);
				rs=ps.executeQuery();
				rs.next();
				vo.setId(rs.getString(1));
				vo.setName(rs.getString(2));
				vo.setAdmin(rs.getString(3));
				rs.close();
				
	
		}
		
		else {
			vo.setMsg("NOPWD");
		}
		
		
		
	}
	} catch (Exception e) {
	
		// TODO: handle exception
		
		e.printStackTrace();
	}
	finally {
		dbconn.disConnection(conn, ps);
	}
	return  vo;
	
}
}
