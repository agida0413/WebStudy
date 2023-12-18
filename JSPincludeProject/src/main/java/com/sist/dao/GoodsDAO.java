package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sist.dbcp.CreateDBCPconnection;
import com.sist.vo.GoodsVO;

public class GoodsDAO {
private Connection conn;
private PreparedStatement ps;
private CreateDBCPconnection dbconn= new CreateDBCPconnection();
private static GoodsDAO dao;


public static GoodsDAO newInstance() {
	if (dao==null) {
		dao=new GoodsDAO();
	}
	return dao;
	
}
//전체 상품 목록
public List<GoodsVO> goodAllListData(int page){
	List<GoodsVO>list=new ArrayList<>();
	
	try {
		conn=dbconn.getConnection();
		String sql="SELECT no,goods_name,goods_poster,goods_price,num "
					+"FROM (SELECT no,goods_name,goods_poster,goods_price,rownum as num "
					+"FROM (SELECT no,goods_name,goods_poster,goods_price "
					+"FROM goods_all ORDER BY no ASC)) "
					+"WHERE num BETWEEN ? AND ?";
		ps=conn.prepareStatement(sql);
		int rowsize=12;
		int start=(rowsize*page)-(rowsize-1);
		int end=(rowsize*page);
		ps.setInt(1, start);
		ps.setInt(2, end);
		ResultSet rs =ps.executeQuery();
		while(rs.next()) {
			GoodsVO vo =new GoodsVO();
			vo.setNo(rs.getInt(1));
			vo.setGoods_name(rs.getString(2));
			vo.setGoods_poster(rs.getString(3));
			vo.setGoods_price(rs.getString(4));
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
//전체 상품 

public int totalpage() {
	int total=0;
	try {
		conn=dbconn.getConnection();
		String sql="SElECT CEIL(COUNT(*)/12.0) FROM goods_all";
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
	

	
}
