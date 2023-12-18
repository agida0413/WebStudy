package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sist.dbcp.CreateDBCPconnection;
import com.sist.vo.SeoulVO;

/*
 * 
 * 
 * NO                                        NOT NULL NUMBER
 TITLE                                     NOT NULL VARCHAR2(200)
 POSTER                                    NOT NULL VARCHAR2(500)
 MSG                                       NOT NULL VARCHAR2(4000)
 ADDRESS                                   NOT NULL VARCHAR2(300)
 HIT                                                NUMBER
 */
public class SeoulDAO {
private Connection conn;
private PreparedStatement ps;
private CreateDBCPconnection dbconn= new CreateDBCPconnection();
private static SeoulDAO dao;
private final int ROW_SIZE=12;


public static SeoulDAO newInstance() {
	if(dao==null) {
		dao=new SeoulDAO();
	}
	return dao;
	
}

public List<SeoulVO> seoulListData(int page){
	List<SeoulVO> list= new ArrayList<>();
	try {
		conn=dbconn.getConnection();
		String sql="SELECT no,title,poster,msg,address,num "
					+"FROM (SELECT no,title,poster,msg,address,rownum as num "
					+"FROM (SELECT no,title,poster,msg,address "
					+"FROM seoul_location ORDER BY no )) "
					+"WHERE num BETWEEN ? AND ? ";
					
		int start=(ROW_SIZE*page)-(ROW_SIZE-1);
		int end=ROW_SIZE*page;
		ps=conn.prepareStatement(sql);
		ps.setInt(1, start);
		ps.setInt(2, end);
		ResultSet rs= ps.executeQuery();
		while(rs.next()) {
			SeoulVO vo=new SeoulVO();
			vo.setNo(rs.getInt(1));
			vo.setTitle(rs.getString(2));
			vo.setPoster(rs.getString(3));
			vo.setMsg(rs.getString(4));
			
			list.add(vo);
		}
		rs.close();
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	finally {
		dbconn.disConnection(conn, ps);
	}
	
	return list;
	
}

public int totalpage() {
	int totalpage=0;
	try {
		conn=dbconn.getConnection();
		String sql="SELECT CEIL(COUNT(*)/"+ROW_SIZE+") FROM seoul_location";
		ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		
		rs.next();
		totalpage=rs.getInt(1);
		rs.close();
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	finally {
		dbconn.disConnection(conn, ps);
	}
	
	return totalpage;
	
}

public SeoulVO detailLocation(int sno) {
	SeoulVO vo =new SeoulVO();
		try {
			conn=dbconn.getConnection();
			String sql="SELECT no,title,poster,msg,address FROM seoul_location WHERE no="+sno;
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setTitle(rs.getString(2));
			vo.setPoster(rs.getString(3));
			vo.setMsg(rs.getString(4));
			vo.setAddress(rs.getString(5));
			rs.close();
					
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			dbconn.disConnection(conn, ps);
		}
	
	return vo;
}

}
