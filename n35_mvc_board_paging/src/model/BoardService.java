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
	
	public ListVO getBoardList(String pageNo)throws SQLException{
		int ipageNo=Integer.parseInt(pageNo);
		ListVO lvo=new ListVO(boardDao.getBoardList(pageNo),new PagingBean(boardDao.totalCount(), ipageNo));
		if(pageNo==null || pageNo=="")
			pageNo="1";//페이징 처리를 안했기 때문에 no에는 무조건 1이 들어간다..
		
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
	
	public int totalCount()throws SQLException{
		return boardDao.totalCount();
	}
}









