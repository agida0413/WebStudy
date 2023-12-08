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
      
      public BoardVO boardDetailData(int no) {
    	  BoardVO  vo=new BoardVO();
    	  
    	  try {
			getConnection();
			String sql ="UPDATE replyboard SET "
						+"hit=hit+1 "
						+"WHERE no="+no;
			ps=conn.prepareStatement(sql);
			ps.executeUpdate();
			//조회수 증가 
			sql="SELECT no,name,subject,content,TO_CHAR(regdate,'YYYY-MM-dd hh24:MI:SS'),hit "
					+"FROM replyboard "
					+"WHERE no="+no;
			ps=conn.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			
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
		}
    	  finally {
			disConnection();
		}
    	  
    	  return vo;
    	  
      }
      
      public BoardVO boardUpdateData(int no) {
    	  BoardVO  vo=new BoardVO();
    	  
    	  try {
			getConnection();
			
			String sql="SELECT no,name,subject,content "
					+"FROM replyboard "
					+"WHERE no="+no;
			ps=conn.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setSubject(rs.getString(3));
			vo.setContent(rs.getString(4));
		
			
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	  finally {
			disConnection();
		}
    	  
    	  return vo;
    	  
      }
      
      //실제수정 =>request , response =>Ajax(70%)
      
      
      public boolean boardUpdate(BoardVO vo) {
    	  boolean bCheck=false;
    	  
    	  try {
			getConnection();
			String sql="SELECT pwd FROM replyBoard where no="+vo.getNo();
			ps=conn.prepareStatement(sql);
			ResultSet rs =ps.executeQuery();
			
			rs.next();
			String db_pwd=rs.getString(1);
			rs.close();
			
			if (db_pwd.equals(vo.getPwd())) {
				bCheck=true;
				sql="UPDATE replyBoard SET "
					+"name=?,subject=?,content=? "
					+"WHERE no=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, vo.getName());
				ps.setString(2, vo.getSubject());
				ps.setString(3, vo.getContent());
				ps.setInt(4, vo.getNo());
				
				ps.executeUpdate();
				
				}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	  finally {
    		  disConnection();
		}
    	  
    	  return bCheck;
    	  
    	  
      }
      
      //답변 
      public void bordReplyInsert(int pno,BoardVO vo) {
    	  
    	  // 1. pno => group_id, group_tab,step 
    	  // 2.=> 답변의 핵심 
    	  /*
    	   * AAAA				gi gs gt
    	   *  =>BBBB 			1      
    	   *  	=>CCCC			1
    	   * 					1
    	   * ddddd			    2 
    	   *  
    	   * */
    	  // 3. insert 
    	  
    	  
    	  // 4. depth 증가 
    	  
    	  try {
    		  
			getConnection();
			//1. gi gs,gt 
			String sql = "SELECT group_id,group_step,group_tab "
						+"FROM replyBoard "
						+"WHERE no="+pno;
			ps=conn.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			rs.next();
			int group_id=rs.getInt(1);
			int group_step=rs.getInt(2);
			int group_tab=rs.getInt(3);
			
			rs.close();
			//위치 조정
			
			sql="UPDATE replyboard SET "
					+"group_step=group_step+1 "
					+"WHERE group_id=? and group_step>?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, group_id);
			ps.setInt(2, group_step);
			ps.executeUpdate();
			
			//실제 답변
			sql="INSERT INTO replyBoard(no,name,subject,content,pwd,"
				+"group_id,group_step,group_tab,root) "
					+"values(rb_no_seq.nextval,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getSubject());
			ps.setString(3, vo.getContent());
			ps.setString(4, vo.getPwd());
			ps.setInt(5, group_id);
			ps.setInt(6, group_step+1);
			ps.setInt(7, group_tab+1);
			ps.setInt(8,pno);
			ps.executeUpdate();
			//depth 증가 
			
			sql="UPDATE replyBoard SET "
				+"deptth=deptth+1 "
				+"WHERE no="+pno;
			ps=conn.prepareStatement(sql);
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	  finally {
			disConnection();
    		  
		}
    	  
      }
      //삭제처리 
      public boolean boardDelete(int no,String pwd) {
    	  boolean bCheck=false;
    	  try {
			getConnection();
			//1.비밀번호 검색
			String sql ="SELECT pwd,root,deptth "
						+"FROM replyBoard "
						+"WHERE no="+no;
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			rs.next();
			
			String db_pwd=rs.getString(1);
			int root=rs.getInt(2);
			int depth =rs.getInt(3);
			rs.close();
			
			
			if (db_pwd.equals(pwd)) {
				bCheck=true;
				if (depth==0) {
					sql="DELETE FROM replyBoard WHERE no="+no;
					ps=conn.prepareStatement(sql);
					ps.executeUpdate();
				}
				else {
					String msg="관리자가 삭제한 게시물입니다.";
					sql="UPDATE replyBoard SET subject=? ,content=? "
							+"WHERE no=?";
					ps=conn.prepareStatement(sql);
					ps.setString(1, msg);
					ps.setString(2, msg);
					ps.setInt(3, no);
					
					ps.executeUpdate();
				}
				sql="UPDATE replyBoard SET deptth=deptth-1 "
						+"WHERE no="+root;
				ps=conn.prepareStatement(sql);
				ps.executeUpdate();
				
			
			}
			
			
			
			//2.
			/*
			 * 비밀번호가 맞는경우
			 * 2-1.root,depth
			 * 		=>depth==0 =  >delete 
			 * 			depth!=0 = > update
			 * 2-2.depth 감소 =>root
			 * 
			 * 비밀번호가 틀린경우
			 * */
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	  finally {
			disConnection();
		}
    	  
    	  return bCheck;
    	  
      }
      
      
}