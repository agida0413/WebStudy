package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sist.dbcp.CreateDBCPconnection;
import com.sist.vo.FoodVO;

import oracle.jdbc.driver.DBConversion;

public class FoodDAO {
private Connection conn;
private PreparedStatement ps;
private CreateDBCPconnection dbconn=new CreateDBCPconnection();
private static FoodDAO dao;

public static FoodDAO newInstance() {
	if (dao==null) {
		dao=new FoodDAO();
		
	}
	return dao;
}

//평점별 12개 출력
public List<FoodVO> foodBestListData(String type){
List<FoodVO> list= new ArrayList<>();

try {
	conn=dbconn.getConnection();
	String sql="SELECT fno,name,poster,rownum "
				+"FROM (SELECT fno,name,poster,type "
				+"FROM FOOD_menu_house ORDER BY score DESC) "
				+"WHERE type=? AND rownum <=12 ";
	ps=conn.prepareStatement(sql);
	ps.setString(1,type);
	ResultSet rs= ps.executeQuery();
	while(rs.next()) {
		FoodVO vo=new FoodVO();
		vo.setFno(rs.getInt(1));
		vo.setName(rs.getString(2));
		vo.setPoster("https://www.menupan.com"+rs.getString(3));
		list.add(vo);
	}
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
