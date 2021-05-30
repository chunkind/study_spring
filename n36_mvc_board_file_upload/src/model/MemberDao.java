package model;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

public class MemberDao {
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	public MemberVO login(MemberVO vo)throws SQLException{
		return (MemberVO)sqlSession.selectOne("Member.login", vo);
	}
}











