package com.product.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.product.MyProductService;
import com.product.impl.MyProductServiceImpl;
import com.product.model.MyProductVO;

public class MyProductController extends MultiActionController{
	private MyProductService myProductService;

	
	public void setMyProductService(MyProductService myProductService) {
		this.myProductService = myProductService;
	}

	public ModelAndView insert(HttpServletRequest request, 
						HttpServletResponse response,MyProductVO vo)throws Exception{
		
		System.out.println("1. 폼으로부터 받은 VO :: "+vo); //0
		//비지니스로직 호출...전
		myProductService.insertMyProduct(vo);
		//비지니스로직 호출...후
		System.out.println("2. 폼으로부터 받은 VO :: "+vo); //1
		
		return new ModelAndView("insert_result","info",vo);
	}
	
	public ModelAndView findByProductName(HttpServletRequest request, 
			HttpServletResponse response)throws Exception{
		String word = request.getParameter("word");
		return new ModelAndView("find_result","list",myProductService.findByProductName(word));
	}
	
	public ModelAndView findByMaker(HttpServletRequest request, 
			HttpServletResponse response)throws Exception{
		String word = request.getParameter("word");
		return new ModelAndView("find_result","list",myProductService.findByMaker(word));
	}
}











