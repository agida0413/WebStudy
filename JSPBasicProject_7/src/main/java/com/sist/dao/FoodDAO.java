package com.sist.dao;
import com.sist.dbcp.*;
import java.util.*;
import java.sql.*;

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
//목록
public List<FoodVO> foodListData(int page,String fd,String ss){
	List<FoodVO>list= new ArrayList<>();
	
	
	
	
	try {
		
		conn=dbconn.getConnection();
		
		String sql="SELECT fno,poster,name,address,num "
				+"FROM (select fno,poster,name,address,rownum as num "
				+"FROM (select fno,poster,name,address "
				+"FROM food_menu_house  "
				+"WHERE "+fd+" LIKE '%'||?||'%' "
				+"ORDER BY fno ASC)) "
				+"WHERE num BETWEEN ? AND ?";
	ps=conn.prepareStatement(sql);
	int rowSize=12;
	int start=(rowSize*page)-(rowSize-1);
	int end=rowSize*page;
	//컬럼명/테이블명은 ?로 처리할수없다
	//ps.setStrubg(1,fd)=>address =>'address'
	ps.setString(1, ss);
	ps.setInt(2, start);
	ps.setInt(3, end);
	//fd=>field data , ss =>search 
	ResultSet rs=ps.executeQuery();
	
	while(rs.next()) {
		FoodVO vo =new FoodVO();
		vo.setFno(rs.getInt(1));
		vo.setName(rs.getString(3));
		vo.setPoster(rs.getString(2));
		vo.setAddress(rs.getString(4));
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

public int foodTotalPage(String fd,String ss) {
	int total=0;
	
	try {
		
		
		conn=dbconn.getConnection();
		String sql="SELECT CEIL(count(*)/12.0) "
				+"FROM food_menu_house  "
				+"WHERE "+fd+" LIKE '%'||?||'%'";
		ps=conn.prepareStatement(sql);
		ps.setString(1, ss);
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
//총페이지 =>1.데이터 베이스=>어떤 값(요청)
//상세보기 => 2.화면 어떤 데이터가 필요한지..

public FoodVO foodDetailData(int fno)
{
   // ss / fd => 화면 이동할 때 사용하는 변수
   FoodVO vo=new FoodVO();
   try
   {
      conn=dbconn.getConnection();
      String sql="SELECT fno,poster,name,type,address,phone,"
            + "score,theme,price,time,seat,content "
            + "FROM food_menu_house "
            + "WHERE fno="+fno;
      ps=conn.prepareStatement(sql);
      ResultSet rs=ps.executeQuery();
      rs.next();
      vo.setFno(rs.getInt(1));
      vo.setPoster(rs.getString(2));
      vo.setName(rs.getString(3));
      vo.setType(rs.getString(4));
      vo.setAddress(rs.getString(5));
      vo.setPhone(rs.getString(6));
      vo.setScore(rs.getDouble(7));
      vo.setTheme(rs.getString(8));
      vo.setPrice(rs.getString(9));
      vo.setTime(rs.getString(10));
      vo.setSeat(rs.getString(11));
      vo.setContent(rs.getString(12));
      rs.close();
   }catch(Exception ex)
   {
      ex.printStackTrace();
   }
   finally
   {
      dbconn.disConnection(conn, ps);
   }
   return vo;
}

	
}
