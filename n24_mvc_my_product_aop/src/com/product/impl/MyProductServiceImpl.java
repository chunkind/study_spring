package com.product.impl;

import java.util.List;

import com.product.MyProductDao;
import com.product.MyProductService;
import com.product.model.MyProductVO;

public class MyProductServiceImpl implements MyProductService{
	private MyProductDao myProductDao;	
	
	public void setMyProductDao(MyProductDao myProductDao) {
		this.myProductDao = myProductDao;
	}
	public void insertMyProduct(MyProductVO vo)throws Exception{
		myProductDao.insertMyProduct(vo);
	}
	//  //////////추가///////////
	public List<MyProductVO> findByProductName(String name) throws Exception{
		return myProductDao.findByProductName(name);
	}
	public List<MyProductVO> findByMaker(String maker) throws Exception{
		return myProductDao.findByMaker(maker);
	}
}














