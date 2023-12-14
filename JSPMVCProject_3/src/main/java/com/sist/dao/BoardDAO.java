package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sist.dbcp.CreateDBCPconnection;
import com.sist.vo.boardVO;

public class BoardDAO {
private Connection conn;
private PreparedStatement ps;
private CreateDBCPconnection ddbconn = new CreateDBCPconnection();
private final int ROW_SIZE=10;
private static BoardDAO dao;


public static BoardDAO newInstance() {
	if(dao==null) {
		dao=new BoardDAO();
	}
	return dao;
}

public List<boardVO> boardListData(int page){
	List<boardVO> list= new ArrayList<>();
	
	try {
		conn=ddbconn.getConnection();
		String sql="SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD'),hit, num "
					+"FROM(SELECT no,subject,name,regdate,hit,rownum as num "
					+"FROM(SELECT no,subject,name,regdate,hit "
					+"FROM jspBOARD ORDER BY no DESC)) "
					+"WHERE num between ? and ? ";
		ps=conn.prepareStatement(sql);
		int start=(ROW_SIZE*page)-(ROW_SIZE-1);
		int end=ROW_SIZE*page;
		ps.setInt(1, start);
		ps.setInt(2, end);
		ResultSet rs= ps.executeQuery();
		while(rs.next()) {
			boardVO vo =new boardVO();
			vo.setNo(rs.getInt(1));
			vo.setSubject(rs.getString(2));
			vo.setName(rs.getString(3));
			vo.setDbday(rs.getString(4));
			vo.setHit(rs.getInt(5));
			list.add(vo);
			
		}
		rs.close();
	} catch (Exception e) {
		// TODO: handle exception
	e.printStackTrace();
	}
	finally {
		ddbconn.disConnection(conn, ps);
	}
	return list;
}

public int boardTotalpage() {
	int total=0;
	try {
		conn= ddbconn.getConnection();
		String sql="SELECT CEIL(COUNT(*)/"+ROW_SIZE+") FROM jspboard";
		ps=conn.prepareStatement(sql);
		ResultSet rs= ps.executeQuery();
		rs.next();
		total=rs.getInt(1);
		rs.close();
		} catch (Exception e) {
		// TODO: handle exception
	e.printStackTrace();
	}
	finally {
		ddbconn.disConnection(conn, ps);
	}
	
	return total;
}

public void boardInsert(boardVO vo) {
	
try {
	conn= ddbconn.getConnection();
	String sql="INSERT INTO jspboard(no,name,subject,content,pwd) "
				+"VALUES(jb_no_seq.nextval,?,?,?,?)";
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
	ddbconn.disConnection(conn, ps);
}


}

public boardVO boardDetail(int no) {
	boardVO vo =new boardVO();
	try {
	conn=ddbconn.getConnection();
	String sql="UPDATE jspboard SET "
				+"hit = hit+1 "
				+"where no="+no;
	ps=conn.prepareStatement(sql);
	ps.executeUpdate();
	
	sql="SELECT no,name,subject,content,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS'),hit "
		+"FROM jspboard "
		+"WHERE no="+no;
	ps=conn.prepareStatement(sql);
	ResultSet rs=ps.executeQuery();
	rs.next();
	vo.setNo(rs.getInt(1));
	vo.setName(rs.getString(2));
	vo.setSubject(rs.getString(3));
	vo.setContent(rs.getString(4));
	vo.setDbday(rs.getString(5));
	vo.setHit(rs.getInt(6));
	rs.close();
	
	
	
	} catch (Exception e) {
		// TODO: handle exception
	e.printStackTrace();
	}
	finally {
		ddbconn.disConnection(conn, ps);
	}
	return vo;
}
}
