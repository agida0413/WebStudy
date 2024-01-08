package com.sist.dao;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class EmpDAO {

	//파싱(xml)
	//map.put("id","SELECT~")
	private static SqlSessionFactory ssf;
	//xml을 전송 = > 파싱 
	
	static {
		try {
			//1.xml읽어온다
			Reader reader =Resources.getResourceAsReader("Config.xml");
			
			//2.xml에 설정된 데이터 읽기 =>map
			ssf =new SqlSessionFactoryBuilder().build(reader);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		
	}
	
	public static List<EmpVO> empListData(){
		SqlSession session = ssf.openSession();//getconnect
		List<EmpVO> list=session.selectList("empListData");
		session.close();
		return list;
	}
	
	public static List<EmpVO> empJoinData(){
		SqlSession session = ssf.openSession();//getconnect
		List<EmpVO> list=session.selectList("empDeptJoinData");
		session.close();
		return list;
	}
	public static List<String> empNameData(){
		SqlSession session = ssf.openSession();//getconnect
		List<String> list=session.selectList("empNameData");
		session.close();
		return list;
	}
	
	public static List<EmpVO> empFindData(String[] names){
		SqlSession session = ssf.openSession();//getconnect
		Map hashmap= new HashMap<>();
		hashmap.put("names", names);
		List<EmpVO> list=session.selectList("empFindData",hashmap);
		session.close();
		return list;
		
	}
	
	
	
}
