package com.sist.dao;
import java.util.*;
import java.sql.*;
import com.sist.dbcp.*;
import com.sist.vo.FoodCategoryVO;
import com.sist.vo.FoodVO;

public class FoodDAO {
   // 1. 연결 객체
   private Connection conn;
   // 2. SQL 송수신
   private PreparedStatement ps;
   // 3. DBCP
   private CreateDBCPconnection dbconn=new CreateDBCPconnection();
   // 4. Singleton(싱글턴)
   private static FoodDAO dao;
   
   // 기능 => 1. 카테고리 읽기
   public List<FoodCategoryVO> food_category_data()
   {
      List<FoodCategoryVO> list=
            new ArrayList<FoodCategoryVO>();
      try
      {
         // 1. 주소값 읽기 (오라클 연결)
         conn=dbconn.getConnection();
         // 2. SQL 문장 => 문장 설정
         String sql="SELECT cno,title,poster "
               + "FROM food_category "
               + "ORDER BY cno ASC";
         // 3. SQL 문장 전송
         ps=conn.prepareStatement(sql);
         // 4. 실행 요청
         ResultSet rs =ps.executeQuery();
         
         while(rs.next()) {
        	 FoodCategoryVO vo=new FoodCategoryVO();
        	 vo.setCno(rs.getInt(1));
        	 vo.setTitle(rs.getString(2));
        	 vo.setPoster(rs.getString(3));
        	 list.add(vo);
        	 //ROW매칭
         }
      }catch(Exception ex)
      {
         ex.printStackTrace();
      }
      finally
      {
         // 반환 (싱글턴) => 재사용할 수 있게 해준다
         dbconn.disConnection(conn, ps);
      }
      return list;
   }
   // 기능 => 2. 로그인 => session (*****)
   // => 메뉴변경 => session
   
   
   public List<FoodVO> foodAllData(int page){
	   
	   List<FoodVO> list=new ArrayList<>();
	   try {
		conn=dbconn.getConnection();
		String sql="Select fno,name,poster,num "
				+"FROM (Select fno,name,poster,rownum as num "
				+"FROM (SELECT fno,name,poster "
				+"FROM food_menu_house ORDER BY fno ASC)) "
				+"WHERE num BETWEEN ? AND ?";
		ps=conn.prepareStatement(sql);
		int rowSize=12;
		int start =(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		
		ps.setInt(1, start);
		ps.setInt(2, end);
		ResultSet rs= ps.executeQuery();
		
		while(rs.next()) {
			
		FoodVO vo= new FoodVO();
		vo.setFno(rs.getInt(1));
		vo.setName(rs.getString(2));
		vo.setPoster(rs.getString(3));
		
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
   
   
   public int foodAlltotalpage() {
	   int total=0;
	   
	   try {
		   conn=dbconn.getConnection();
		   String sql="SELECT CEIL(COUNT(*)/12.0) "
				   	+"FROM food_menu_house";
		   ps=conn.prepareStatement(sql);
		   ResultSet rs =ps.executeQuery();
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
   
   
 public List<FoodVO> foodfindAllData(int page,String ss){
	   
	   List<FoodVO> list=new ArrayList<>();
	   try {
		conn=dbconn.getConnection();
		String sql="Select fno,name,poster,num "
				+"FROM (Select fno,name,poster,rownum as num "
				+"FROM (SELECT fno,name,poster "
				+"FROM food_menu_house WHERE name LIKE '%'||?||'%' OR address LIKE '%'||?||'%' ORDER BY fno ASC)) "
				+"WHERE num BETWEEN ? AND ?";
		ps=conn.prepareStatement(sql);
		int rowSize=12;
		int start =(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		ps.setString(1, ss);
		ps.setString(2, ss);
		ps.setInt(3, start);
		ps.setInt(4, end);
		ResultSet rs= ps.executeQuery();
		
		while(rs.next()) {
			
		FoodVO vo= new FoodVO();
		vo.setFno(rs.getInt(1));
		vo.setName(rs.getString(2));
		vo.setPoster(rs.getString(3));
		
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
   
   
   
 public List<FoodVO> foodfindData(int page,String fs,String ss){
	   
	   List<FoodVO> list=new ArrayList<>();
	   try {
		conn=dbconn.getConnection();
		String sql="Select fno,name,poster,num "
				+"FROM (Select fno,name,poster,rownum as num "
				+"FROM (SELECT fno,name,poster "
				+"FROM food_menu_house WHERE "+fs + " LIKE '%'||?||'%' ORDER BY fno ASC)) "
				+"WHERE num BETWEEN ? AND ?";
		ps=conn.prepareStatement(sql);
		int rowSize=12;
		int start =(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		ps.setString(1, ss);
		ps.setInt(2, start);
		ps.setInt(3, end);
		ResultSet rs= ps.executeQuery();
		
		while(rs.next()) {
			
		FoodVO vo= new FoodVO();
		vo.setFno(rs.getInt(1));
		vo.setName(rs.getString(2));
		vo.setPoster(rs.getString(3));
		
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
 
 public int foodFindtotalpage(String fs,String ss) {
	   int total=0;
	   
	   try {
		   conn=dbconn.getConnection();
		   String sql="SELECT CEIL(COUNT(*)/12.0) "
				   	+"FROM food_menu_house "
				   +"WHERE "+fs+" LIKE '%'||?||'%'";
		   
		   ps=conn.prepareStatement(sql);
		   ps.setString(1, ss);
		   ResultSet rs =ps.executeQuery();
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
 
 public int foodFindAlltotalpage(String ss) {
	   int total=0;
	   
	   try {
		   conn=dbconn.getConnection();
		   String sql="SELECT CEIL(COUNT(*)/12.0) "
				   	+"FROM food_menu_house "
				   +"WHERE name LIKE '%'||?||'%' OR address LIKE '%'||?||'%'";
		   
		   ps=conn.prepareStatement(sql);
		   ps.setString(1, ss);
		   ps.setString(2, ss);
		   ResultSet rs =ps.executeQuery();
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