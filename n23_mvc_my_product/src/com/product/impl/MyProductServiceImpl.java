package com.product.impl;

import java.util.List;

import com.product.model.MyProductVO;

public class MyProductServiceImpl {
	private MyProductDaoImpl myProductDaoImpl;

	public void setMyProductDaoImpl(MyProductDaoImpl myProductDaoImpl) {
		this.myProductDaoImpl = myProductDaoImpl;
	}
	
	public void insertMyProduct(MyProductVO vo) throws Exception {
		myProductDaoImpl.insertMyProduct(vo);
	}
	
	//추가
	public List<MyProductVO> findMyProductName(String name) throws Exception {
		return myProductDaoImpl.findMyProductName(name);
	}
	
	public List<MyProductVO> findByMaker(String maker) throws Exception {
		return myProductDaoImpl.findByMaker(maker);
	}
}
