package com.product.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.product.impl.MyProductServiceImpl;
import com.product.model.MyProductVO;

public class MyProductController extends MultiActionController{
	private MyProductServiceImpl myProductServiceImpl;
	
	public void setMyProductServiceImpl(MyProductServiceImpl myProductServiceImpl) {
		this.myProductServiceImpl = myProductServiceImpl;
	}
	
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response,
			MyProductVO vo) throws Exception {
		
		System.out.println("1. 폼으로부터 받은 VO ::" +vo);//0
		//비지니스로직 호출..전
		myProductServiceImpl.insertMyProduct(vo);
		//비지니스로직 호출..후
		System.out.println("2. 폼으로부터 받은 VO ::" +vo);//1
		
		return new ModelAndView("insert_result","info",vo);
	}

	public ModelAndView findByProductName(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String word = request.getParameter("word");
		return new ModelAndView("find_result","list",myProductServiceImpl.findMyProductName(word));
	}
	
	public ModelAndView findByMaker(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String word = request.getParameter("word");
		return new ModelAndView("find_result","list",myProductServiceImpl.findByMaker(word));
	}
}
