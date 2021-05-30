package model;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

public class BoardDao {
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int write(BoardVO bvo) throws SQLException{
		return sqlSession.insert("Board.write", bvo);
	}
	
	public String selectByNoForDate(int no) throws SQLException{
		return sqlSession.selectOne("Board.selectByNoForDate", no);
	}
	
	//getBoardList
	//showContent
	//deleteBoard
	public List<BoardVO> getBoardList(String no)throws SQLException{
		return sqlSession.selectList("Board.getBoardList",no);
	}
	
	public BoardVO showContent(String no)throws SQLException{
		return sqlSession.selectOne("Board.showContent",no);
	}
	
	public void deleteBoard(String no) throws SQLException{
		sqlSession.delete("Board.deleteBoard", no);
	}
	
	public void updateCount(String no) throws SQLException{
		sqlSession.update("Board.updateCount", no);
	}
	
	public void updateBoard(BoardVO bvo)throws SQLException{
		sqlSession.update("Board.updateBoard",bvo);
	}
	public int totalCount()throws SQLException{
		return sqlSession.selectOne("Board.totalCount");
	}
	
}






















