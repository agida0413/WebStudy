package com.sist.dao;
import java.util.*;
import java.sql.*;
//DB연동만 있는것은 아니다 => 크롤링 , JSON 
public class EmpDAO {

	private Connection conn;
	private PreparedStatement ps;
	private final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static EmpDAO dao;
	
	//드라이버 등록
	
	public EmpDAO() {
		
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
		}
		
	}
	
	public static EmpDAO newInstacne() {
		
		if (dao==null) {
			dao=new EmpDAO();
		}
		
		return dao;
		
	}
	
	
//기능(사용자 요청 )
	
	public List<EmpVO> empListData(){
		List<EmpVO>list = new ArrayList<EmpVO>();
		try {
			getConnection();
			String sql="SELECT empno,ename,job,hiredate,sal "
						+"FROM emp";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
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
		disConnection();	
		}
		
		return list;
		
	}
	
	
	
}
