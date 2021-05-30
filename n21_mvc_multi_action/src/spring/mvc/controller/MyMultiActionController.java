package spring.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
/*
 * 우리는 여태껏 요청을 할때마다 처리해줄 Component를 각각 만들었다.
 * DeleteController, UpdateController...이런식으로...
 * command=delete, command=update
 * ::
 * MultiActionController를 상속받게 되면 command 값에 따라서 컨트롤러가 각각
 * 생성되는 것이 아니라 하나의 controller를 생성하고 그안에 메소드가 각각 정의되도록 만들어졌다.
 * 
 * MyMultiActionController :: delete(), update()
 * ::
 * 이 원리를 이해하면,
 * 예전 방식은 요청 갯수 만큼 controller가 만들어져야 했다면
 * 지금은 하나의 controller에 요청 갯수만큼의 메소드가 지정되면 된다.
 */
public class MyMultiActionController extends MultiActionController{
	
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response){
		//비지니스 로직 요청..
		System.out.println("update() Call...");
		return new ModelAndView("update_result", "info", "Update OK!!");
	}
	
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response){
		//비지니스 로직 요청..
		System.out.println("delete() Call...");
		return new ModelAndView("delete_result", "info", "Delete OK!!");
	}
}
