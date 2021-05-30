package model;

import java.sql.SQLException;
import java.util.List;

public class MemberServiceImpl implements MemberService{
	private MemberDao memberDao;
	
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Override
	public void registerMember(MemberVO vo) throws SQLException {
		memberDao.registerMember(vo);
	}

	@Override
	public boolean idcheck(String id) throws SQLException {
		boolean result = false;
		if(memberDao.idcheck(id) != null){ //이미 디비에 있다면....
			result = true;
		}
		return result;
	}

	@Override
	public MemberVO login(MemberVO vo) throws SQLException {
		return memberDao.login(vo);
	}

	@Override
	public void updateMember(MemberVO vo) throws SQLException {
		memberDao.updateMember(vo);
	}

	@Override
	public List<MemberVO> findByAddress(String address) throws SQLException {
		return memberDao.findByAddress(address);
	}

	@Override
	public List<String> getAddressKind() throws SQLException {
		return memberDao.getAddressKind();
	}

	@Override
	public List<MemberVO> getAllMember() throws SQLException {
		return memberDao.getAllMember();
	}
}







