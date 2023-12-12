package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sist.dbcp.CreateDBCPconnection;

public class EmpDAO {
private Connection conn;
private PreparedStatement ps;


private CreateDBCPconnection dbconn= new CreateDBCPconnection(); 

public List<EmpVO> enpListData(){
	
	List<EmpVO> list= new ArrayList<EmpVO>();
	
	try {
		conn= dbconn.getConnection();
		String sql= "SELECT empno,ename,job,hiredate,sal FROM emp ORDER BY sal DESC";
		
				ps=conn.prepareStatement(sql);
				ResultSet rs= ps.executeQuery();
				while(rs.next()) {
					EmpVO vo =new EmpVO();
					vo.setEmpno(rs.getInt(1));
					vo.setEname(rs.getString(2));
					vo.setJob(rs.getString(3));
					vo.setHiredate(rs.getDate(4));
					vo.setSal(rs.getInt(5));
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

}
