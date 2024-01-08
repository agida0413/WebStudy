package com.sist.dao;

import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MusicDAO {
private static SqlSessionFactory ssf;
	//초기화 xml을 파싱 


static {
	//자동인식 
	try {
		Reader reader=Resources.getResourceAsReader("Config.xml");
		ssf=new SqlSessionFactoryBuilder().build(reader);
		
	} catch (Exception e) {
			e.printStackTrace();
			
	}
	
	
}

public static List<MusicVO> musicFindData(Map hashmap){
	
	SqlSession session=null;
	List<MusicVO>list= new ArrayList<MusicVO>();
	

	try {
		
		session = ssf.openSession();
		list=session.selectList("musicFindData",hashmap);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	finally {
		if(session!=null) {
			session.close();
		}
	}
	
	return list;
}

	
}
