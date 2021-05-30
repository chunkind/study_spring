package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PersonVO;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class TestAjaxController extends MultiActionController{
	//동기통신...
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response){
		System.out.println("동기통신....insert()...");
		return new ModelAndView("insert_ok");
		//insert_ok으로 요청하면...member>insertOK.jsp가 뷰페이지..가 되도록..
	}
	
	//비동기 통신
	/*
	 * BeanNameResolver ::
	 * 1. view result 페이지의 다양한 디렉토리 설정을 위해서 필요
	 * 2. ajax-Json 뷰페이지 매핑을 위해서 필요
	 */
	public ModelAndView searchById(HttpServletRequest request, HttpServletResponse response){
		System.out.println("비동기통신....searchById()...");
		return new ModelAndView("JsonView", "person",new PersonVO("김연아", "태능"));
	}
}








