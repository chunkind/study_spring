package com.product.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.product.model.MyProductVO;

public class MyProductDaoImpl {
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		System.out.println("::" + getClass().getName() + ".setSqlSession() Call");
		this.sqlSession = sqlSession;
	}
	
	//addProduct
	public void insertMyProduct(MyProductVO vo) throws Exception{
		int result = sqlSession.insert("Product.insertMyProduct", vo);
		System.out.println("INSERT PRODUCT OK " + result);
	}
	
	/// 추가
	public List<MyProductVO> findMyProductName(String name) throws Exception {
		return sqlSession.selectList("Product.findByProductName", name);
	}
	
	public List<MyProductVO> findByMaker(String maker) throws Exception {
		return sqlSession.selectList("Product.findByMaker", maker);
	}
	
	
}
