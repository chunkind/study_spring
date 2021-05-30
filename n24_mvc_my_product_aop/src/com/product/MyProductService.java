package com.product;

import java.util.List;

import com.product.model.MyProductVO;

public interface MyProductService {
	public void insertMyProduct(MyProductVO vo)throws Exception;
	public List<MyProductVO> findByProductName(String name) throws Exception;
	public List<MyProductVO> findByMaker(String maker) throws Exception;
}
