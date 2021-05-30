package model;

import java.sql.SQLException;
import java.util.List;
//Dao에서 가져온 값을 사용하기 좋게 수정하여 Controller로 전달
public class MemberServiceImpl implements MemberService{
	//Dao에서 값을 받아오기 위해 필드로 선언
	private MemberDao memberDao;
	//xml에서 주입을 하려면 필요하기때문에 setter생성
	//필드의 주입은 생성자 주입과 setter밖에 없다..
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	//registerMember
	@Override
	public void registerMember(MemberVO vo) throws SQLException {
		//정보를 수정할 필요가 없으므로 리턴 타입 void
		memberDao.registerMember(vo);
	}
	//idcheck
	@Override
	public boolean idcheck(String id) throws SQLException {
		//dao에서 리턴 된 값이 없을 경우 false 있으면 true
		boolean idcheck = false;
		//dao에서 VO로 리턴된다. 찾는 아이디가 없을 경우 VO가 비어 있다.
		if(memberDao.idcheck(id) != null){
			idcheck = true;
		}
		//id체크한 정보를 true 혹은 false로 리턴
		return idcheck;
	}
	//login
	@Override
	public MemberVO login(MemberVO vo) throws SQLException {
		return memberDao.login(vo);
	}
	//updateMember
	@Override
	public void updateMember(MemberVO vo) throws SQLException {
		//정보를 수정할 필요가 없으므로 리턴 타입 void
		memberDao.updateMember(vo);
		
	}
	//findByAddress
	@Override
	public List<MemberVO> findByAddress(String address) throws SQLException {
		return memberDao.findByAddress(address);
	}
	//getAddressKind
	@Override
	public List<String> getAddressKind() throws SQLException {
		return memberDao.getAddressKind();
	}
	//getAllMember
	@Override
	public List<MemberVO> getAllMember() throws SQLException {
		return memberDao.getAllMember();
	}	
}