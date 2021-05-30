package com.aop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.aop.model.ReportService;

public class ReportController extends MultiActionController{
	private ReportService reportService;

	public void setReportService(ReportService reportService) {
		this.reportService = reportService;
	}
	
	public ModelAndView selectReport(HttpServletRequest request,
								HttpServletResponse response)throws Exception{
		ModelAndView mv = new ModelAndView();
		List list=reportService.selectReport();
		System.out.println("selectReport...Call.....");
		
		mv.setViewName("report_result");
		mv.addObject("list",list);
		return mv;
		
	}	
}












