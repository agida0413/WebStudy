package com.sist.dao;
import java.sql.*;
import java.util.*;
public class ProductDAO {
   private Connection conn;
   private PreparedStatement ps;
   private final String URL="jdbc:oracle:thin:@211.238.142.102:1521:XE";
   private static ProductDAO dao;
   // 드라이버 등록 => 한번만 생성
   public ProductDAO()
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
   public static ProductDAO newInstance()
   {
      // 라이브러ㅣ => newInstance, getInstance() => 싱글턴
      if(dao==null)
         dao=new ProductDAO(); // null이면 생성 => 한번만 생성됨
      return dao; // null이면 그전에 생성한 값을 가져다 쓴다
   }
   // 기능 설정
   // => 목록(table) => 인라인뷰 => 페이지 설정
   public List<ProductVO> foodListData(int page)
   {
      List<ProductVO> list=new ArrayList<ProductVO>();
      // FOODVO = ROW => row 리스트에 담아준다고 이해하면편함
      // https://www.menupan.com/
      // /restaurant/restimg/001/zzmenuimg/e40054110_z.jpg => 서브주소 필요
      // //restaurant/restimg/001/zzmenuimg/e40054110_z.jpg => http://restaurant/restimg/001/zzmenuimg/e40054110_z.jpg => 서브주소 필요없음
/*
 *이미지
 * 상품이름</th>");
       out.println("<th width=10%>순위</th>");
       out.println("<th width=15%>평점</th>");
       out.println("<th width=15%>가격</th>");
       out.println("<th width=15%>할인율</th>");
       out.println("<th width=20%>할인가</th>");
 *     
 */
      
      try
      {
         getConnection();
         // 페이지마다 데이터 읽기
         int rowSize=20;
         // num BETWEEN ? AND ? => 1page 1~20
         //                     2page 21~40
         int start=(rowSize*page)-(rowSize-1);
         int end=rowSize*page;
         String sql="SELECT p_image,product_name,product_rank,product_grade,product_price,product_sale,sale_price "
        		 +"FROM product_inform "
                 + "WHERE product_rank BETWEEN ? AND ? "
        		 ;
         
         ps=conn.prepareStatement(sql);
         ps.setInt(1, start);
         ps.setInt(2, end);
         // INDEX_ASC(테이블명 인덱스명, pk, uk) , INDEC_DESC(), INDEX()
         ResultSet rs=ps.executeQuery();
         while(rs.next())
         {
            ProductVO vo=new ProductVO();
            vo.setP_image(rs.getString(1));
            vo.setProduct_name(rs.getString(2));
            vo.setProduct_rank(rs.getInt(3));
            vo.setProduct_grade(rs.getDouble(4));
            vo.setProduct_price(rs.getString(5));
            vo.setProduct_sale(rs.getString(6));
            vo.setSale_price(rs.getString(7));
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
         String sql="SELECT CEIL(COUNT(*)/20.0) FROM product_list";
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
   
   public List<ProductVO> searchProduct(String message){
	   List<ProductVO>list= new ArrayList();
	   try
	      {
	         getConnection();
	         // 페이지마다 데이터 읽기
	      
	    
	         String sql="select product_name ,product_rank "
	        		 +"FROM product_inform "
	        		 +"WHERE product_name LIKE "+"%"+message+"% "
	        		 +"ORDER BY product_rank";
	         
	         ps=conn.prepareStatement(sql);
	     
	         // INDEX_ASC(테이블명 인덱스명, pk, uk) , INDEC_DESC(), INDEX()
	         ResultSet rs=ps.executeQuery();
	         while(rs.next())
	         {
	            ProductVO vo=new ProductVO();
	           vo.setProduct_name(rs.getString(1));
	           vo.setProduct_rank(rs.getInt(2));
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
   

	
	
}










