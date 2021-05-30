package com.aop.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

public class ReportDaoImpl implements ReportDao{
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		
		System.out.println("::"+getClass().getName()+".setSqlSession() Call..");
		this.sqlSession = sqlSession;
	}
	
	@Override
	public void insertReport(String word) throws Exception {
		sqlSession.insert("Report.insertReport",word);
	}
	@Override
	public int updateReport(String word) throws Exception {
		return sqlSession.update("Report.updateReport", word);		
	}
	@Override
	public List selectReport() throws Exception {
		return sqlSession.selectList("Report.selectReport");
	}
}



