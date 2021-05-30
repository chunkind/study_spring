package model;

import java.sql.SQLException;

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
}









