package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberService;
import model.MemberVO;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MemberController extends MultiActionController{
	private MemberService memberService;
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response
										,MemberVO pvo)throws Exception{
		MemberVO rvo=memberService.login(pvo);
		if(rvo != null){
			request.getSession().setAttribute("mvo", rvo);
		}
		return new ModelAndView("member/login_result");//이미 위에서 했다.
	}
	//logout
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws Exception {
		session.invalidate();
		return new ModelAndView("index");
	}
}











