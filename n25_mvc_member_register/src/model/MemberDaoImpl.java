package model;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
/*
 * Dao이기때문에 싱글톤으로 만드는게 좋을듯 하다
 * ::
 * 싱글톤은 독립적으로 사용되야 하는 객체에서 사용한다.
 * (new로 여러개가 생성 되지 않기 위해 사용)
 */
public class MemberDaoImpl implements MemberDao{
	//db에 접속하기위해 session이 필요하므로 필드로 지정
	private SqlSession sqlSession;
	//xml에서 주입하기위해 setter가 필요
	//출력문으로 무엇이 들어왔는지 확인//디버깅시 필요
	public void setSqlSession(SqlSession sqlSession) {
		System.out.println("::"+getClass().getName()+".setSqlSession call....");
		this.sqlSession = sqlSession;
	}
	//registerMember
	@Override
	public void registerMember(MemberVO vo) throws SQLException {
		//Member.registerMember::member.xml에서 namespace로 지정한 이름.sql문 이름
		sqlSession.insert("Member.registerMember", vo);
		System.out.println("insert ok..!");//inser실패시 뜨지 않는다.
	}
	//idcheck
	@Override
	public Object idcheck(String id) throws SQLException {
		//받아올 대상이 1개이기때문에 selectOne사용 VO가 리턴된다.
		return sqlSession.selectOne("Member.idcheck", id); 
	}
	//login
	@Override
	public MemberVO login(MemberVO vo) throws SQLException {
		return sqlSession.selectOne("Member.login", vo);
	}
	//updateMember
	@Override
	public void updateMember(MemberVO vo) throws SQLException {
		 sqlSession.update("Member.updateMember", vo);
		 System.out.println("updateMember ok..!");//디버깅시 필요
	}
	//findByAddress
	@Override
	public List<MemberVO> findByAddress(String address) throws SQLException {
		//List타입으로 여러개의 MemberVO를 리턴 받으므로 selectList사용::Map등 여러가지 컬렉션 사용가능
		return sqlSession.selectList("Member.findByAddress",address);
	}
	//getAddressKind
	@Override
	public List<String> getAddressKind() throws SQLException {
		//List타입으로 여러개의 address를 리턴 받으므로 selectList사용
		return sqlSession.selectList("Member.getAddressKind");
	}
	//getAllMember
	@Override
	public List<MemberVO> getAllMember() throws SQLException {
		//List타입으로 여러개의 MemberVO를 리턴 받으므로 selectList사용
		return sqlSession.selectList("Member.getAllMember");
	}
}