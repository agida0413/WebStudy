package com.sist.dao;
import java.sql.*;
import java.util.*;
public class FoodDAO {
   private Connection conn;
   private PreparedStatement ps;
   private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
   private static FoodDAO dao;
   // 드라이버 등록 => 한번만 생성
   public FoodDAO()
   {
      try
      {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         // new 대신 사용 => 틀래스명으로 메모리 할당 => 리플렉션  
      }catch(Exception ex) {}
   }
   // 오라클 연동
   public void getConnection()
   {
      try
      {
         conn=DriverManager.getConnection(URL,"hr","happy");
         // => conn hr/happy
      }catch(Exception ex) {}
   }
   // 오라클 닫기
   public void disconnection()
   {
      try
      {
         if(ps!=null) ps.close();
         if(conn!=null) conn.close();
         
      }catch(Exception ex) {}
   }
   // 싱글턴 패턴 => 메모리 공간 한개만 생성
   public static FoodDAO newInstance()
   {
      // 라이브러ㅣ => newInstance, getInstance() => 싱글턴
      if(dao==null)
         dao=new FoodDAO(); // null이면 생성 => 한번만 생성됨
      return dao; // null이면 그전에 생성한 값을 가져다 쓴다
   }
   // 기능 설정
   // => 목록(table) => 인라인뷰 => 페이지 설정
   public List<FoodVO> foodListData(int page)
   {
      List<FoodVO> list=new ArrayList<FoodVO>();
      // FOODVO = ROW => row 리스트에 담아준다고 이해하면편함
      // https://www.menupan.com/
      // /restaurant/restimg/001/zzmenuimg/e40054110_z.jpg => 서브주소 필요
      // //restaurant/restimg/001/zzmenuimg/e40054110_z.jpg => http://restaurant/restimg/001/zzmenuimg/e40054110_z.jpg => 서브주소 필요없음
      try
      {
         getConnection();
         // 페이지마다 데이터 읽기
         int rowSize=20;
         // num BETWEEN ? AND ? => 1page 1~20
         //                     2page 21~40
         int start=(rowSize*page)-(rowSize-1);
         int end=rowSize*page;
         String sql="SELECT fno, poster, name, type, address,num "
               + "FROM (SELECT fno, poster, name, type, address,rownum as num "
               + "FROM (SELECT /*+INDEX_ASC(food_menu_house fh_fno_pk)*/fno, poster, name, type, address "
               + "FROM food_menu_house)) "
               + "WHERE num BETWEEN ? AND ?";
         ps=conn.prepareStatement(sql);
         ps.setInt(1, start);
         ps.setInt(2, end);
         // INDEX_ASC(테이블명 인덱스명, pk, uk) , INDEC_DESC(), INDEX()
         ResultSet rs=ps.executeQuery();
         while(rs.next())
         {
            FoodVO vo=new FoodVO();
            vo.setFno(rs.getInt(1));
            vo.setPoster("https://www.menupan.com/"+rs.getString(2));
            vo.setName(rs.getString(3));
            vo.setType(rs.getString(4));
            vo.setAddress(rs.getString(5));
            list.add(vo);
            
         }
      }
      catch(Exception ex)
      {
         ex.printStackTrace();
      }
      finally
      {
         disconnection();
      }
      return list;
   }
   // 총페이지 
   public int foodTotalPage()
   {
      int total=0;
      try
      {
         getConnection();
         String sql="SELECT CEIL(COUNT(*)/20.0) FROM food_menu_house";
         ps=conn.prepareStatement(sql);
         ResultSet rs=ps.executeQuery();
         rs.next();
         total=rs.getInt(1);
         rs.close();
      }
      catch(Exception ex)
      {
      ex.printStackTrace();   
      }
      finally
      {
         disconnection();
      }
      return total;
   }
   // => 상세보기 (table) 
   
   
   
  
}









