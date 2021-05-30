package model;

import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public class MemberDaoImpl implements MemberDao{
	private SqlSessionTemplate sqlSession;
	
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public void registerMember(MemberVO vo) throws SQLException {
		sqlSession.insert("Member.registerMember", vo);
	}

	@Override
	public Object idcheck(String id) throws SQLException {
		return sqlSession.selectOne("Member.idcheck", id);
	}

	@Override
	public MemberVO login(MemberVO vo) throws SQLException {
		return (MemberVO)sqlSession.selectOne("Member.login", vo);
	}

	@Override
	public void updateMember(MemberVO vo) throws SQLException {
		sqlSession.update("Member.updateMember", vo);
	}

	@Override
	public List<MemberVO> findByAddress(String address) throws SQLException {
		return sqlSession.selectList("Member.findByAddress", address);
	}

	@Override
	public List<String> getAddressKind() throws SQLException {
		return sqlSession.selectList("Member.getAddressKind");
	}

	@Override
	public List<MemberVO> getAllMember() throws SQLException {
		
		return sqlSession.selectList("Member.getAllMember");
	}
}












