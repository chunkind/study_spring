package model;

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
	
	public List<BoardVO> getBoardList(String no)throws SQLException{
		if(no==null || no=="")
			no="1";//페이징 처리를 안했기 때문에 no에는 무조건 1이 들어간다..
		
		return boardDao.getBoardList(no);
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
}