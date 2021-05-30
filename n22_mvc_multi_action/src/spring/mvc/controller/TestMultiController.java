package spring.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class TestMultiController extends MultiActionController{
	
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("delete_result", "infoDelete", "DELETE..OK!");
	}
	
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("update_result", "infoUpdate", "UPDATE..OK!");
	}
}
