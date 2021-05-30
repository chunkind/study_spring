package model;

import java.sql.SQLException;
import java.util.List;
/*
 * interface
 * 구상 객체를 노출시키지 않기 위해 사용
 * 상속받는 대상을 제어하기 좋다.
 */
public interface MemberDao {
	public void registerMember(MemberVO vo) throws SQLException;
	public Object idcheck(String id) throws SQLException;
	public MemberVO login(MemberVO vo)throws SQLException;
	public void updateMember(MemberVO vo)throws SQLException;
	public List<MemberVO> findByAddress(String address)throws SQLException;
	public List<String> getAddressKind()throws SQLException;
	public List<MemberVO> getAllMember() throws SQLException;	
}










