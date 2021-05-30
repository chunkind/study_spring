package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BoardService;
import model.BoardVO;
import model.MemberVO;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class BoardController extends MultiActionController{
	private BoardService boardService;
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	/*
	 *==== 로그인한 사람만 글쓴다. =====
	 *SessionScope에서 mvo라는 이름의 객체를 찾아와야한다.
	 *mvo라는 이름의 객체가 있다는 것은 로긴 하고 들어왔다는 의미...-글쓰기 작업이 가능하다.
	 *1)인자값의 bvo에 로긴된 mvo정보를 주입(hasing) :: 완벽한 bvo가 된다
	 *2)boardService.write(bvo);
	 *3)최종적으로 MemberVO가 인식된 BoardVO를 MV에 바인딩하고 뷰페이지(자기 글 보기)로 이동
	 */
	public ModelAndView write(HttpServletRequest request, HttpServletResponse response,
							HttpSession session,BoardVO bvo) throws Exception{
		MemberVO mvo = (MemberVO)session.getAttribute("mvo");
		if(mvo==null){ //로그인 상태에서 이곳으로 들어온게 아니기 때문에 글쓰기 못함
			return  new ModelAndView("redirect:/index.jsp");			
		}
		bvo.setMemberVO(mvo); //bvo와 mvo의 hasing이 실질적으로 일어난다.
		
		//그리고 나서 write()를 해야지만 인증받은 사용자가 글을쓰는게 된다..
		boardService.write(bvo);
		
		return new ModelAndView("board/show_content","bvo", bvo); //바인딩
	}
}