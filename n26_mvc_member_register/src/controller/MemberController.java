package controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberService;
import model.MemberVO;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MemberController extends MultiActionController {
	private MemberService memberService;

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	// service의 biz() 호출....
	// redirect 방식으로 전송
	public ModelAndView register(HttpServletRequest request, HttpServletResponse response, MemberVO vo)
			throws Exception {
		memberService.registerMember(vo);
		return new ModelAndView("redirect:/member.do?command=getAllMember");
	}

	public ModelAndView idcheck(HttpServletRequest request, HttpServletResponse response) throws Exception {
		boolean flag = memberService.idcheck(request.getParameter("id"));
		return new ModelAndView("idcheck", "flag", flag);
	}

	// 주의!!..login_ok, login_fail
	// 메소드의 인자값 주의...사용자의 정보를 session에 바인딩 해야 한다..
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			MemberVO pvo) throws SQLException {
		String path = "login_fail";

		MemberVO rvo = memberService.login(pvo);
		System.out.println("pvo ::" + pvo); // 확인...name, address값은 null
		System.out.println("rvo ::" + rvo); // 확인

		if (rvo != null) {
			// 중요!!
			session.setAttribute("vo", rvo);
			path = "login_ok";
		}
		return new ModelAndView(path); // 이미 위에서 바인딩은 됬다.
	}

	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws SQLException {
		if (session.getAttribute("vo") != null)
			session.invalidate();

		return new ModelAndView("redirect:/index.jsp"); // 생각!!
	}

	// HttpSession을 인자값으로 넣지 않고 진행하자....
	public ModelAndView updateMember(HttpServletRequest request, HttpServletResponse response, MemberVO pvo)
			throws SQLException {
		memberService.updateMember(pvo);// 이 부분에서 디비의 vo내용이 pvo로 수정이 일어났다.
		// 그걸 다시 세션에 반드시 바인딩 해야한다.
		request.getSession().setAttribute("vo", pvo);
		return new ModelAndView("update_result");// 바인딩은 이미 위에서 했다.

	}

	public ModelAndView findByAddress(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		List<MemberVO> memList = memberService.findByAddress(request.getParameter("address"));

		return new ModelAndView("findByAddress_result", "memList", memList);
	}

	public ModelAndView getAddressKind(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		List<String> list = memberService.getAddressKind();
		return new ModelAndView("findByAddress", "list", list);

	}

	public ModelAndView getAllMember(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		List<MemberVO> allList = memberService.getAllMember();
		return new ModelAndView("allMember_result", "allList", allList);
	}
}
