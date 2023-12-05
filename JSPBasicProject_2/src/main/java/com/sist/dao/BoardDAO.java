package com.sist.dao;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import java.sql.*;
public class BoardDAO {
   private Connection conn;
   private PreparedStatement ps;
   
   private static BoardDAO dao;
   // 미리 연결된 Connection 객체
    public void getConnection()
      {
         try
         {
            // 저장시에 => 탐색기 형식으로 메모리 주소를 저장 JNDI(Java Naming Directory..)
            // c:\ , java://comp/env => jdbc/oracle
            // 1. 탐색기 열기
            Context init=new InitialContext();
            
            // 2. 저장된 위치 확인
            Context c=(Context)init.lookup("java://comp/env");
            // 3. 실제 Connection 주소 얻기 
            DataSource ds=(DataSource)c.lookup("jdbc/oracle");
            // 4. Connection의 정보를 받는다 
            conn=ds.getConnection();
            
         }catch(Exception ex) {}
      }
      // 사용후에 반환 
      public void disConnection()
      {
         try
         {
            if(ps!=null) ps.close();
            if(conn!=null) conn.close();
         }catch(Exception ex) {}
      }
      
      // 싱글턴 
      public static BoardDAO newInstance()
      {
         if(dao==null)
            dao=new BoardDAO();
         return dao;
      }
      // 기능 => 목록 출력 (페이징) 사용자가 요청한 값 (매개변수)
      public List<BoardVO> boardListData(int page)
      {
        List<BoardVO> list=new  ArrayList<BoardVO>();
         try
         {
         getConnection();
         String sql="SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD'),hit,group_tab,num "
               + "FROM (SELECT no,subject,name,regdate,hit,group_tab, ROWNUM AS num "
               + "FROM(SELECT no,subject,name,regdate,hit,group_tab "
               + "FROM replyBoard ORDER BY group_id DESC, group_step ASC)) "
               + "WHERE num BETWEEN ? AND ?";
         ps=conn.prepareStatement(sql);
         int rowSize=10;
         int start=(page*rowSize)-(rowSize-1);
         int end=page*rowSize;
         
         ps.setInt(1, start);
         ps.setInt(2, end);
         
         ResultSet rs=ps.executeQuery();
         while(rs.next())
         {
            BoardVO vo=new BoardVO();
            vo.setNo(rs.getInt(1));
            vo.setSubject(rs.getString(2));
            vo.setName(rs.getString(3));
            vo.setDbday(rs.getString(4));
            vo.setHit(rs.getInt(5));
            vo.setGroup_tab(rs.getInt(6));
            list.add(vo);
         }
         rs.close();
         
         }
         catch(Exception ex)
         {
            ex.printStackTrace();
         }
         finally
         {
            disConnection();
         }
         return list;
      }
      // findByNo(int no) where no=1 ==> jpa => 쿼리문장 자동 생성
      public int boardRowCount() // 총 게시물 갯수 (COUNT *) 을 구해서 출력시 count-- 로 출력 => 7 6 5 ... 1
      // <td width=10% class="text-center"><%=count-- %></td>
      {
         int count=0;
         try
         {
            getConnection();
            String sql="SELECT COUNT(*) FROM replyBoard";
            ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            rs.next();
            count=rs.getInt(1);
            rs.close();
         }
         catch(Exception ex)
         {
            ex.printStackTrace();
         }
         finally
         {
            disConnection();
         } 
         return count;
      }
      public void boardInsert(BoardVO vo)
      {
         try
         {
            getConnection();
            String sql="INSERT INTO replyBoard("
                  + "no,name,subject,content,pwd,group_id) "
                  + "VALUES(rb_no_seq.nextval,?,?,?,?, "
                  + "(SELECT NVL(MAX(group_id)+1,1) FROM replyboard))";
            ps=conn.prepareStatement(sql);
            ps.setString(1, vo.getName());
            ps.setString(2, vo.getSubject());
            ps.setString(3, vo.getContent());
            ps.setString(4, vo.getPwd());
            ps.executeUpdate();
            
         }
         catch(Exception ex)
         {
            ex.printStackTrace();
         }
         finally
         {
            disConnection();
         }
      }
      
}