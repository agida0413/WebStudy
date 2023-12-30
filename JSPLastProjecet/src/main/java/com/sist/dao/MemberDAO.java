package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sist.dbcp.CreateDBCPconnection;
import com.sist.vo.ZipcodeVO;

public class MemberDAO {
private Connection conn;
private PreparedStatement ps;
private CreateDBCPconnection dbconn=new CreateDBCPconnection();

private static MemberDAO dao;

public static MemberDAO newInstance() {
	if(dao==null)
		dao=new MemberDAO();
	return dao;
}


//id중복체크 

public int memberIdCheck(String id) {
	int count=0;
	
	try {
		conn=dbconn.getConnection();
		String sql="SELECT COUNT(*) FROM project_member "
					+"WHERE id=?";
		ps=conn.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs=ps.executeQuery();
		rs.next();
		count=rs.getInt(1);
		rs.close();
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		
	}
	finally {
		dbconn.disConnection(conn, ps);
	}
	return count;
	
}

public List<ZipcodeVO> postfind(String dong){
	List<ZipcodeVO> list=new ArrayList<>();
	try {
		conn=dbconn.getConnection();
		String sql="SELECT zipcode,sido,gugun,"
					+"dong,NVL(bunji,' ') "
					+"FROM zipcode "
					+"WHERE dong LIKE '%'||?||'%'";
			ps=conn.prepareStatement(sql);
			ps.setString(1, dong);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ZipcodeVO vo=new ZipcodeVO();
				vo.setZipcode(rs.getString(1));
				vo.setSido(rs.getString(2));
				vo.setGugun(rs.getString(3));
				vo.setDong(rs.getString(4));
				vo.setBunji(rs.getString(5));
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

public int postfindCount(String dong) {
	int count=0;
	try {
		conn=dbconn.getConnection();
		String sql="SELECT COUNT(*) "
					+"FROM zipcode "
					+"where dong LIKE '%'||?||'%'";
		ps=conn.prepareStatement(sql);
		ps.setString(1, dong);
		ResultSet rs=ps.executeQuery();
		rs.next();
		count=rs.getInt(1);
		rs.close();
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	finally {
		dbconn.disConnection(conn, ps);
	}
	return count;
}

public 
}
