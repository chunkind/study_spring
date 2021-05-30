package model;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

public class BoardService {
	private BoardDao boardDao;

	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	public void write(BoardVO bvo) throws SQLException{
		System.out.println("Before No 확인 :: "+bvo.getNo()); //0
		int no=boardDao.write(bvo);//   0/1
		System.out.println("After No 확인 :: "+bvo.getNo()); //1
		
		String date=boardDao.selectByNoForDate(bvo.getNo());
		bvo.setWriteDate(date); //이부분이 있어야 날짜가 출력된다...
	}
	
	public ListVO getBoardList(String pageNo)throws SQLException{
		if(pageNo==null | pageNo=="")//목록보기 버튼을 누를경우 최신글을 보여주기 위해서 setting
			pageNo = "1";//페이징 처리 안해서 최근 페이지를 보여지도록 한다.
		
		// @@@@@@@@ 페이징 처리시 수정되는 부분 @@@@@@@@@
		List<BoardVO> list=boardDao.getBoardList(pageNo);
		int total=boardDao.totalCount();
		PagingBean paging=  new PagingBean(total, Integer.parseInt(pageNo));
		ListVO lvo = new ListVO(list, paging);
		return lvo;
	}
	
	public BoardVO showContent(String no)throws SQLException{
		return boardDao.showContent(no);
	}	
	public void deleteBoard(String no) throws SQLException{
		boardDao.deleteBoard(no);
	}
	public void updateCount(String no) throws SQLException{
		boardDao.updateCount(no);
	}
	
	public void updateBoard(BoardVO bvo) throws SQLException{
		boardDao.updateBoard(bvo);
	}
	
	//upload폴더에 있는 newfilename을 삭제하는 기능..Service Layer 본연의 기능
	public void deleteFile(String newfilename){
		File file = new File(newfilename);
		System.out.println(newfilename+"..file delete.." +file.delete());
	}
}









