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
//모든 command 타입을 여기서 처리
public class MemberController extends MultiActionController{
	//Dao=>service를 거쳐 완성된 형태의 정보로 리턴된다.
	//db에 접속하기위해 service가 필요하므로 필드로 선언
	private MemberService memberService;
	//xml에서 주입하기위해 setter생성
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	//service의 biz() 호출....
	//redirect 방식으로 전송
	public ModelAndView register(HttpServletRequest request, HttpServletResponse response, MemberVO vo)
	throws Exception{
		//db에 insert
		memberService.registerMember(vo);
		//회원 가입후 가입이 잘 되었는지 확인을 위해 redirect방식으로 아래의 getAllMember를 호출한다.
		//MemberController를 거쳐 다시 getAllMember를 호출한다.
		return new ModelAndView("redirect:/member.do?command=getAllMember");
	}
	
	public ModelAndView idcheck(HttpServletRequest request, HttpServletResponse response)
	throws Exception{
		String id = request.getParameter("id");
		boolean flag = memberService.idcheck(id);
		//service에서 수정된 정보를 받아와 view페이지로 
		//바인딩해준다.
		//ModelAndView(이동할 페이지 이름, 바인딩할 이름, 바인딩할 객체)
		return new ModelAndView("idcheck.jsp","flag",flag);
	}
	//주의!!..login_ok, login_fail
	//메소드의 인자값 주의...사용자의 정보를 session에 바인딩 해야 한다..
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response
			, HttpSession session, MemberVO pvo)
		throws SQLException{
		//if문에서 성공/실패 페이지로 나뉠것이기 때문에 mv를 미리 선언해둔다.
		ModelAndView mv = new ModelAndView();
		//login정보를 session.setAttribute해주기 위해 vo로 가져온다.
		MemberVO vo = memberService.login(pvo);
		//vo가 null이 아니라는것은 로그인정보가 일치 한다는 뜻이다.
		if(vo != null){
			System.out.println("로그인 성공");
			mv.setViewName("login_ok.jsp");
			//vo가 있을 경우에만 session에 바인딩한다.
			session.setAttribute("vo", vo);
		}else{
			System.out.println("로그인 실패");
			mv.setViewName("login_fail.jsp");
		}
		return mv; 
	}
	//메소드에서 바로 vo와 session을 인자 값으로 받아올수 있다
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response
			, HttpSession session)
		throws SQLException{
		//session에서 getAttribute를 했을때 비어있지 
		//않다면 로그인중이므로 session을 비워 로그아웃 상태로 만든다.
		if(session.getAttribute("vo") != null)
			session.invalidate();
		
		return new ModelAndView("index.jsp");
	}
	//HttpSession을 인자값으로 넣지 않고 진행하자....
	public ModelAndView updateMember(HttpServletRequest request, HttpServletResponse response
			, MemberVO pvo)
		throws SQLException{
		//dao에서 정보를 수정
		memberService.updateMember(pvo);
		//session을 가져오는 방법
		HttpSession session = request.getSession();
		//인자값으로 들어온 정보는 db에 수정되는 정보와 같으므로 인자값을 세션에 바인딩하여
		//로그인 정보를 수정해준다.
		//로그인 정보와 db정보를 동일화 해주어야 한다.
		session.setAttribute("vo", pvo);
		return new ModelAndView("update_result.jsp");
		
	}	
	public ModelAndView findByAddress
	(HttpServletRequest request, HttpServletResponse response)
		throws SQLException{
		String address = request.getParameter("address");
		//ModelAndView(이동할 페이지 이름, 바인딩할 이름, 바인딩할 객체)
		return new ModelAndView("findByAddress_result.jsp","memList",memberService.findByAddress(address));
	}
	
	public ModelAndView getAddressKind
	(HttpServletRequest request, HttpServletResponse response)
			throws SQLException{
		String address = request.getParameter("address");
		//ModelAndView(이동할 페이지 이름, 바인딩할 이름, 바인딩할 객체)
		return new ModelAndView("findByAddress.jsp","list",memberService.getAddressKind());		
	}
	
	public ModelAndView getAllMember(HttpServletRequest request, HttpServletResponse response)
			throws SQLException{
		List<MemberVO> list = memberService.getAllMember();
		//한 번만 응답하면 될 경우 request.setAttribute
		request.setAttribute("list", list);
		return new ModelAndView("allMember_result.jsp","allList",list);
	}
}