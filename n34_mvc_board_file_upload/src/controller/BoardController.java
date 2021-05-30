package controller;

import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BoardService;
import model.BoardVO;
import model.ListVO;
import model.MemberVO;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class BoardController extends MultiActionController {
	// FileUpload 추가....
	private String path;

	public void setPath(String path) {
		this.path = path;
	}

	private BoardService boardService;

	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	/*
	 * ==== 로그인한 사람만 글쓴다. =====SessionScope에서 mvo라는 이름의 객체를 찾아와야한다.mvo라는 이름의 객체가
	 * 있다는 것은 로긴 하고 들어왔다는 의미...-글쓰기 작업이 가능하다.1)인자값의 bvo에 로긴된 mvo정보를 주입(hasing)
	 * :: 완벽한 bvo가 된다2)boardService.write(bvo);3)최종적으로 MemberVO가 인식된 BoardVO를
	 * MV에 바인딩하고 뷰페이지(자기 글 보기)로 이동
	 */

	public ModelAndView write(HttpServletRequest request,
			HttpServletResponse response, HttpSession session, BoardVO bvo)
			throws Exception {
		MemberVO mvo = (MemberVO) session.getAttribute("mvo");
		if (mvo == null) { // 로그인 상태에서 이곳으로 들어온게 아니기 때문에 글쓰기 못함
			return new ModelAndView("redirect:/index.jsp");
		}
		bvo.setMemberVO(mvo); // bvo와 mvo의 hasing이 실질적으로 일어난다.

		// FileUpload 추가
		MultipartFile mFile = bvo.getUploadFile();
		System.out.println(mFile.getSize() + "======" + mFile.isEmpty());// false
		if (mFile.isEmpty() == false) { // upload 했다
			String fileName = mFile.getOriginalFilename();
			bvo.setOrgfilename(fileName);

			String newfilename = System.currentTimeMillis() + "_" + fileName;
			bvo.setNewfilename(newfilename); // 여기까지 하면 완벽한 세팅.

			// transferTo....
			File colyFile = new File(path + newfilename);
			mFile.transferTo(colyFile);
		}

		// 그리고 나서 write()를 해야지만 인증받은 사용자가 글을쓰는게 된다..
		boardService.write(bvo);

		return new ModelAndView("board/show_content", "bvo", bvo); // 바인딩
	}

	// @@@@@@ 페이징 처리시 수정되어야 함..ListVO 를 리턴 받자!! @@@@@@@@
	public ModelAndView list(HttpServletRequest request,
			HttpServletResponse response) throws SQLException {
		ListVO lvo = boardService.getBoardList(request.getParameter("pageNo"));
		return new ModelAndView("board/list", "lvo", lvo);
	}

	/*
	 * 전체 글보기는 모든 사람이 할수 있다. 상세 글보기(지금 기능)는 로그인 한 사람 만이 권한을 갖는다.
	 */
	public ModelAndView showContent(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		MemberVO mvo = (MemberVO) request.getSession().getAttribute("mvo");
		if (mvo == null) { // 로그인 하지 않고 상세글보기로 들어왔다.
			return new ModelAndView("redirect:/index.jsp");// jsp 확장자 써야한다.
		}

		// 이 부분 추가...조회수 증가 로직...
		boardService.updateCount(request.getParameter("no"));// 이게 먼저

		BoardVO bvo = (BoardVO) boardService.showContent(request
				.getParameter("no"));
		return new ModelAndView("board/show_content", "bvo", bvo);
	}

	public ModelAndView delete(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String newfilename = request.getParameter("newfilename");
		if (newfilename != null) {
			boardService.deleteFile(path + newfilename); // path는 여기서
		}
		boardService.deleteBoard(request.getParameter("no"));
		// @@@@@ 페이징 처리시 수정됨!! @@@@@@
		ListVO lvo = boardService.getBoardList("1");
		return new ModelAndView("board/list", "lvo", lvo);

	}

	// updateView
	public ModelAndView updateView(HttpServletRequest request,
			HttpServletResponse response) throws SQLException {
		return new ModelAndView("/board/update", "bvo",
				boardService.showContent(request.getParameter("no"))); // board/update(수정폼)..이때
																		// 수정의
																		// 대상이
																		// 되는
																		// 컬럼은?
	}

	// updateBoard
	public ModelAndView updateBoard(HttpServletRequest request,
			HttpServletResponse response, BoardVO pvo) throws Exception {
		/*
		 * pvo에 orgfilenanme, newfilename이 없다. 받아와서 다시 주입...
		 */
		MultipartFile mFile = pvo.getUploadFile();
		System.out.println(mFile.getSize() + "======" + mFile.isEmpty());// false
		if (mFile.isEmpty() == false) { // upload 했다
			String fileName = mFile.getOriginalFilename();
			pvo.setOrgfilename(fileName);

			String newfilename = System.currentTimeMillis() + "_" + fileName;
			pvo.setNewfilename(newfilename); // 여기까지 하면 완벽한 세팅.

			// transferTo....
			File colyFile = new File(path + newfilename);
			mFile.transferTo(colyFile);
		}

		boardService.updateBoard(pvo);
		return new ModelAndView("/board/show_content", "bvo",
				boardService.showContent(request.getParameter("no"))); // board/show_content
	}

	// fileDownload
	public ModelAndView fileDownload(HttpServletRequest request,
			HttpServletResponse response) throws SQLException {
		HashMap map = new HashMap();
		map.put("path", path);

		return new ModelAndView("downloadView", map);
	}

	public ModelAndView deleteFile(HttpServletRequest request,
			HttpServletResponse response) throws SQLException {
		String newfilename = request.getParameter("newfilename");
		System.out.println("Ajax....Call....");
		if (newfilename != null) {
			boardService.deleteFile(path + newfilename);
		}
		return new ModelAndView("JsonView");
	}
}
