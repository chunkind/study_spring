package model;

import java.sql.SQLException;

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
}















